package Java_Algo; 

public class ReverseArray {
    public static void main(String[] args) {
        int[] values = {0, 1, 2, 3, 4, 5, 6,}; 
        
        for (int i = 0; i< Math.floor(values.length/2); i++) {
            int temp = values[i]; 
            values[i] = values[values.length - 1 -i]; 
            values[values.length - 1 - i] = temp; 
        }
        System.out.println(java.util.Arrays.toString(values));
    }
}