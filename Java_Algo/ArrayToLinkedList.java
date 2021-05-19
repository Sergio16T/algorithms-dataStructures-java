package Java_Algo;

// Convert Array to LinkedList

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayToLinkedList {
    public static void main(String[] args) {
        // Initialize an Array of strings
        String[] strArr = { "A", "B", "C", "D", "E" };

        // Convert array to list
        List<String> list = Arrays.asList(strArr);

        // Create a LinkedList and
        // pass List in LinkedList constructor
        LinkedList<String> linkedList = new LinkedList<String>(list);

        // Display and print all elements of LinkedList
        System.out.println("LinkedList of above array : " + linkedList);
    }
}