# The-CatSort-Problem-Set

Problem #1: The Recursion Warm Up (10 points):

Write a recursive method to reverse and capitalize a String.  For example:

reverseAndCap("abcdefg3!")

should return:

!3GFEDCBA

Note that non-alphabetic characters are included (but obviously cannot be capitalized).

Also, no points will be given for a non-recursive solution.

 

Problem #2: The Array CatSort (45 points):

Create a "Cat" class with the following attributes:
Name
Weight
Age
Include a constructor and getter methods, and override toString() to display all info (you may let NetBeans do this for you).

In your main method, create an array of 5 Cats and initialize their attributes.
Implement the QuickSort algorithm (as shown in class) to sort Cats by weight.  You may create this as a static recursive method.
Display the sorted array contents in main.
 

Problem #3: The Linked List CatSort (45 points):

Modify the Linked List example that you will be given in class into a LinkedCatList class that implements a Linked List of the Cat objects that you created in Problem #2.
In your main method, create a LinkedCatList of 5 Cats and initialize their attributes.
Create a sort method in your LinkedCatList class that uses QuickSort (implemented by you) to sort the list of Cats alphabetically (lexicographicaly) by Name.
Display the sorted list contents in main.
