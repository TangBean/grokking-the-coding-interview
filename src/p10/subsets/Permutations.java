package p10.subsets;

import java.util.*;

/**
 * Given a set of distinct numbers, find all of its permutations.
 *
 * Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:
 *
 * {1, 2, 3}
 * {1, 3, 2}
 * {2, 1, 3}
 * {2, 3, 1}
 * {3, 1, 2}
 * {3, 2, 1}
 * If a set has ‘n’ distinct elements it will have n!n! permutations.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 *
 *
 * 字典序全排列算法：（只是在这记录一下这个算法，下面并没有使用该算法）
 *
 * 采用字典序排列生成算法，按照字典序升序一个一个的生成排列，比如对于 [1,2,3]，它的生成顺序应为：
 * [1,2,3] -> [1,3,2] -> [2,1,3] -> [2,3,1] -> [3,1,2] -> [3,2,1]
 *
 * 1. 从最右开始，找到第一个升序对中较小的数字，假设为 m；
 * 2. 再从最右开始,找到 m 右边比 m 大的数字，假设为 n；
 * 3. 将 m 和 n 对调，即 [x1, x2, m, x3, x4, n, x5, x6] -> [x1, x2, n, x3, x4, m, x5, x6]；
 * 4. 最后将 n 后面的数字逆序，即 [x1, x2, n, x3, x4, m, x5, x6] -> [x1, x2, n, x6, x5, m, x4, x3]。
 *
 * [x1, x2, n, x6, x5, m, x4, x3] 就是 [x1, x2, m, x3, x4, n, x5, x6] 的下一个字典序排列。
 */
public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = resultList.size();
            for (int j = 0; j < size; j++) {
                List<Integer> halfResult = resultList.get(0);
                for (int k = 0; k <= halfResult.size(); k++) {
                    List<Integer> nextResult = new ArrayList<>(halfResult);
                    nextResult.add(k, nums[i]);
                    resultList.add(nextResult);
                }
                resultList.remove(0);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
