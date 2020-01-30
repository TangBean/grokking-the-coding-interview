package p1.sliding;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the
 * smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0,
 * if no such subarray exists.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 *
 * Example 2:
 *
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 *
 * Example 3:
 *
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int curBegin = 0;
        int sum = arr[0];
        int curEnd = 1;
        while (curEnd < arr.length) {
            if (sum < S) {
                sum += arr[curEnd++];
            } else {
                res = Math.min(res, curEnd - curBegin);
                sum -= arr[curBegin++];
            }
        }

        if (sum < S) {
            return 0;
        }
        while (sum >= S && curBegin < curEnd) {
            res = Math.min(res, curEnd - curBegin);
            sum -= arr[curBegin++];
        }
        return res;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
