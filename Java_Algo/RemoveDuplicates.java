package Java_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class RemoveDuplicates {

    public static Integer[] usingStream(Integer[] arr) {
        Integer[] listWithoutDuplicates = Arrays.asList(arr)
            .stream()
            .distinct()
            .toArray(size -> new Integer[size]);

        return listWithoutDuplicates;
    }

    public static Integer[] usingLinkedHashSet(Integer[] arr) {
        /* The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements.
        When the iteration order is needed to be maintained this class is used.
        LinkedHashSet lets us iterate through the elements in the order in which they were inserted. */
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        for (Integer i = 0; i < arr.length; i++) {
            Integer number = arr[i];
            set.add(number);
        }
        return set.toArray(size -> new Integer[size]);
    }

    public static Integer[] usingHashSet(Integer[] arr) {
        // With Hashset underlying data structure is HashTable - Objects are inserted based on their hash code.
        HashSet<Integer> set = new HashSet<Integer>();

        for (Integer i = 0; i < arr.length; i++) {
            Integer number = arr[i];
            set.add(number);
        }
        return set.toArray(size -> new Integer[size]);
    }

    public static Integer[] nativeSolution(Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (Integer i = 0; i < arr.length; i++) {
            Integer element = arr[i];
            if (list.indexOf(element) >= 0) {
                continue;
            } else {
                list.add(element);
            }
        }

        return list.toArray(size -> new Integer[size]);
    }
    public static void main(String[] args) {
        Integer[] origArray = new Integer[] { 1, 1, 2, 4, 9, 7, 3, 4, 5, 8, 6, 1, 7, 8 };

        Integer[] listWithoutDuplicates = RemoveDuplicates.usingStream(origArray);

        Integer[] setOfIntegers = RemoveDuplicates.usingLinkedHashSet(origArray);
        Integer[] setOfIntegers2 = RemoveDuplicates.usingHashSet(origArray);
        Integer[] listWithoutDup = RemoveDuplicates.nativeSolution(origArray);

        System.out.println("usingStream: " + Arrays.toString(listWithoutDuplicates));
        System.out.println("usingLinkedHashSet: " + Arrays.toString(setOfIntegers));
        System.out.println("usingHashSet: " + Arrays.toString(setOfIntegers2));
        System.out.println("using ArrayList: " + Arrays.toString(listWithoutDup));
    }
}
