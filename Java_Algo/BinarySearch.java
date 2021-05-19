package Java_Algo;

// return the index of value in sorted array, if not present return -1;
// iterative solution

public class BinarySearch {

    int binarySearchDemo(int arr[], int x){
        // int[] values = {0, 1, 2, 3, 4, 5, 6 };
        int left = 0,
            right = arr.length -1;

        while(left < right) {
            double mid = (left + right)/2;
            //explicitly cast double to int,
            int midIndex = (int) Math.floor(mid);
            // System.out.println(midIndex);

           if(arr[midIndex] == x) return midIndex;

           if(arr[midIndex] > x) {
               right = midIndex - 1;
           } else {
               left = midIndex + 1;
           }
        }
        return arr[left] == x ? left : -1;
    }
    public static void main(String[] args) {
        int[] values = {11, 12, 13, 14, 15, 16, 17 };
        BinarySearch demo = new BinarySearch();

        int result = demo.binarySearchDemo(values, 11);

        System.out.println("index of x:" + result);
    }
}

//recursive solution

class RecursiveBinarySearch {
    int binarySearch(int arr[], int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // If the element is present at the middle
            if (arr[mid] == x) return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x) return binarySearch(arr, left, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, right, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        RecursiveBinarySearch recursive = new RecursiveBinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = recursive.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}