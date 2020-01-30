package p1.sliding;

/**
 * Given an array of positive numbers and a positive number ‘k’,
 * find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Example 2:
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        if (k <= 0 || arr == null || arr.length == 0 || arr.length < k) {
            return -1;
        }

        int res = Integer.MIN_VALUE;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k) {
                sum -= arr[i - k];
                if (sum > res) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
