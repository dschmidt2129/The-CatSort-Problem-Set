/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.catsort.problem.set;

import java.util.NoSuchElementException;

/**
 *
 * @author david
 */
public class LinkedCatList {

    Node first;

    private Node currentNode;
    private int length;

    class Node {

        private Cat data;
        private Node next;

        public void printNodeData() {
            System.out.println("Node data: " + data);
        }

        public Node getNext() {
            return next;
        }

    }

    public LinkedCatList() {
        first = null;
        currentNode = null;
        length = 0;
    }

    public void setFirst(Cat value) {
        first.data = value;
    }

    public void setCurrent(Cat value) {
        currentNode.data = value;
    }

    public void addFirst(Cat value) {

        //create the Node and set its value
        Node newNode = new Node();
        newNode.data = value;

        // if newNode is the first node, this will be null
        // otherwise it will point to the former "first" now
        newNode.next = first;

        //set our "first" Node to the Node we just created
        first = newNode;

        currentNode = newNode;

        length++;
    }

    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            first = first.next;
            length--;
        }
    }

    public void remove() {
        if (currentNode == first) {
            removeFirst();
        } else {
            Node tempCurrent = currentNode;
            moveFirst();
            boolean found = false;
            while (!found) {
                if (currentNode.next == tempCurrent) {
                    found = true;
                } else {
                    moveNext();
                }
            }

            currentNode.next = tempCurrent.next;
        }
    }

    public int indexOf(Cat value) {
        Node tempNode = first;
        int position = 0;

        while (tempNode != null) {
            if (tempNode.data == value) {
                return position;
            } else {
                tempNode = tempNode.next;
                position++;
            }
        }

        return -1;

    }

    //adds after currentNode
    public void add(Cat value) {
        if (first == null) {
            addFirst(value);
        } else {

            //create node having "next" pointing to tempSwap
            Node newNode = new Node();
            newNode.data = value;
            newNode.next = currentNode.next;

            //make the old current node point to our newNode
            currentNode.next = newNode;

            //move current refer to node we just added
            moveNext();

            //increment length of list
            length++;
        }

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public int getLength() {
        return length;
    }

    public Cat getFirstValue() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return first.data;
        }
    }

    public Cat getCurrentValue() {
        if (currentNode == null) {
            throw new NoSuchElementException();
        } else {
            return currentNode.data;
        }
    }

    public void moveNext() {
        currentNode = currentNode.next;
    }

    public void moveFirst() {
        currentNode = first;
    }

    public void displayList() {
        Node currentNode = first;
        System.out.println("List contents:");
        while (currentNode != null) {
            currentNode.printNodeData();
            currentNode = currentNode.getNext();
        }
    }

    public Node findTail(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public Node getPrevNode(LinkedCatList catList, Node node) {
        Node tempNode = catList.first;
        for (int i = 0; i < catList.getLength(); i++) {
            if (tempNode.next == node) {
                return tempNode;
            } else {
                tempNode = tempNode.next;
            }
        }
        return tempNode;
    }

    private static void swap(Node a, Node b) {
        Cat tempSwap = a.data;
        a.data = b.data;
        b.data = tempSwap;
    }

    private static Node partition(LinkedCatList catList, Node low, Node high) {
        Node pivot = high;
        Node i = catList.getPrevNode(catList, low);
        for (Node j = low; j != pivot; j = j.next) {
            if ((j.data.getName().compareTo(pivot.data.getName()) <= 0)) {
                if (i == null) {
                    i = low;
                } else {
                    i = i.next;
                }
                swap(i, j);
            }
        }
        if (i == null) {
            i = low;
        } else {
            i = i.next;
        }
        swap(i, high);
        return i;
    }

    public void quickSort(LinkedCatList catList, Node low, Node high) {
        if (high != null && !low.data.getName().equals(high.data.getName()) && low != high.next) {
            Node pivot = partition(catList, low, high);
            Node prevPivot = getPrevNode(catList, pivot);
            quickSort(catList, low, prevPivot);
            quickSort(catList, pivot.next, high);
        }
    }

}
