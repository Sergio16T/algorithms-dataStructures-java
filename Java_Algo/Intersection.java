package Java_Algo;
// return a set of unique values found in both arrays

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.function.Predicate;

/* takes two arguments (each an array) as input
[1, 2, 4, 4, 5, 2, 10, 11], [2, 5, 2, 7, 8, 11, 7, 9]
arrays are unsorted

1) Create a set from array1 to remove duplicates
2) initialize a new array result
3) Loop through elements in the set created from array1 and check if array2 includes the element
4) if array2 does include the element push this element to the result array
5) after loop ends return the result array
*/

public class Intersection {

    public static Integer[] unique(Integer[] array1, Integer[] array2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(array1));
        ArrayList<Integer> arrayGroup2 = new ArrayList<>(Arrays.asList(array2));
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer number : set) {
            Boolean elementInBoth = arrayGroup2.contains(number);
            if (elementInBoth) {
                result.add(number);
            }
        }

        return result.toArray(size -> new Integer[size]);

    }

    public static Integer[] uniqueUsingStreams(Integer[] array1, Integer[] array2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(array1));
        ArrayList<Integer> arrayGroup2 = new ArrayList<>(Arrays.asList(array2));
        Predicate<Integer> numberInBoth = (num) -> arrayGroup2.contains(num);

        Integer[] result = set
            .stream()
            .filter(numberInBoth)
            .toArray(size -> new Integer[size]);

        return result;
    }

    public static Integer[] uniqueWithoutSet(Integer[] array1, Integer[] array2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            Integer numberInFirstArray = array1[i];
            for (int j = 0; j < array2.length; j++) {
                Integer numberInSecondArray = array2[j];
                if (numberInFirstArray == numberInSecondArray && !result.contains(numberInFirstArray)) {
                    result.add(numberInFirstArray);
                }
            }
        }

        return result.toArray(size -> new Integer[size]);
    }


    public static void main(String... args) {
        Integer[] array1 = {1, 2, 4, 4, 5, 2, 10, 11};
        Integer[] array2 = {2, 5, 2, 7, 8, 11, 7, 9};
        Integer[] uniqueResult = Intersection.unique(array1, array2);
        Integer[] uniqueResultUsingStreams = Intersection.uniqueUsingStreams(array1, array2);
        Integer[] uniqueResultWithoutSet = Intersection.uniqueWithoutSet(array1, array2);

        System.out.println(Arrays.toString(uniqueResult)); // [2, 5, 11]
        System.out.println(Arrays.toString(uniqueResultUsingStreams)); // [2, 5, 11]
        System.out.println(Arrays.toString(uniqueResultWithoutSet)); // [2, 5, 11]
    }
}
