package Java_Algo;
// Java code here
// O(n*k) solution for finding
// maximum sum of a subarray
// of size k
// Given an array of integers of size ‘n’.
// Our aim is to calculate the maximum sum of ‘k’
// consecutive elements in the array.
class MaximumSumSubArray {

        // Returns maximum sum in
        // a subarray of size k.
        // sliding window
        static int maxSumSW(int arr[], int k) {
            if (arr.length < k) {
                System.out.println("Invalid");
                return -1;
            }

            // Compute sum of first window of size k
            int max_sum = 0;
            for (int i = 0; i < k; i++) {
                max_sum += arr[i];
            }
            // Compute sums of remaining windows by
            // removing first element of previous
            // window and adding last element of
            // current window.
            int window_sum = max_sum;
            for (int i = k; i < arr.length; i++) {
                // arr[i] last element of current window
                // arr[i - k] first element of previous window
                // example with k equal to 4 --  arr[4] - arr[4 - 4]
                window_sum += arr[i] - arr[i - k];
                max_sum = Math.max(max_sum, window_sum);
            }

            return max_sum;
        }

        // Driver code
        public static void main(String[] args)
        {
            int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
            int k = 4;
            System.out.println(maxSumSW(arr, k));
        }

}

// example solution without sliding window O(n^2)

class GFG {
    // Returns maximum sum in
    //  a subarray of size k.
    static int maxSum(int arr[], int n, int k)
    {
        // Initialize result
        int max_sum = 0;

        // Consider all blocks starting with i.
        for (int i = 0; i < n - k + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < k; j++)
                current_sum = current_sum + arr[i + j];

            // Update result if required.
            max_sum = Math.max(current_sum, max_sum);
        }

        return max_sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
