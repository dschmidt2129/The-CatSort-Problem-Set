/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.catsort.problem.set;

import java.util.Arrays;

/**
 *
 * @author david
 */
public class TheCatSortProblemSet {

    private static String reverseAndCap(String palChecker) {
        if (palChecker.length() == 1) {//fix this statement to account for special characters
            return palChecker.substring(0).toUpperCase();
        } else {
            return reverseAndCap(palChecker.substring(1)).toUpperCase() + palChecker.toUpperCase().charAt(0);
        }
    }

    private static void swap(Cat[] catArr, int a, int b) {
        Cat tempSwap = catArr[a];
        catArr[a] = catArr[b];
        catArr[b] = tempSwap;
    }

    private static int partition(Cat[] catArr, int low, int high) {
        int pivot = catArr[high].getWeight();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (catArr[j].getWeight() < pivot) {
                i++;
                swap(catArr, i, j);
            }
        }
        swap(catArr, i + 1, high);
        return i + 1;
    }

    private static void quickSort(Cat[] catArr, int low, int high) {
        if (low < high) {
            int pivot = partition(catArr, low, high);
            quickSort(catArr, low, pivot - 1);
            quickSort(catArr, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseAndCap("123!abc"));//warm up recursion (Problem #1)

        Cat[] catArray = {new Cat("Whiskers", 15, 2), new Cat("Cat McFly", 12, 4), new Cat("Hank", 9, 1), new Cat("FurMan", 25, 12), new Cat("Garfield", 18, 5)};
        quickSort(catArray, 0, catArray.length - 1);
        System.out.println(Arrays.toString(catArray));//Problem #2

        LinkedCatList catList = new LinkedCatList();
        catList.addFirst(new Cat("Whiskers", 15, 2));
        catList.add(new Cat("Cat McFly", 12, 4));
        catList.add(new Cat("Hank", 9, 1));
        catList.add(new Cat("FurMan", 25, 12));
        catList.add(new Cat("Garfield", 18, 5));
        catList.quickSort(catList, catList.first, catList.findTail(catList.first));
        catList.displayList();//Problem #3

    }

}
