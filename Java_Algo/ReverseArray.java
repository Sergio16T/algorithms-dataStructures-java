package Java_Algo;

import java.util.Arrays;

// 1st case even number of values
// 0, 1, 2, 3
// 3, 1, 2, 0
// 3, 2, 1, 0

// second case odd number of values
// 0, 1, 2, 3, 4
// 4, 1, 2, 3, 0
// 4, 3, 2, 1, 0
public class ReverseArray {
    public static int[] reverse(int[] array) {
        for(int i =0; i < Math.floor(array.length/2); i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] values = { 0, 1, 2, 3, 4, 5, 6 };

        for (int i = 0; i < Math.floor(values.length/2); i++) {
            int temp = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(values));

        // use static method of class ReverseArray
        int[] arrayValues = { 0, 1, 2, 3, 4, 5, 6 };
        int[] reversed = ReverseArray.reverse(arrayValues);
        System.out.println(Arrays.toString(reversed));
    }
}