package p10.subsets;

import java.util.*;

public class SubsetWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }

        Arrays.sort(nums);

        subsets.add(new ArrayList<>());
        subsets.add(Arrays.asList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int n = subsets.size();
            int startIndex = nums[i] != nums[i - 1] ? 0 : n / 2;
            for (int j = startIndex; j < n; j++) {
                List<Integer> curList = new ArrayList<>(subsets.get(j));
                curList.add(nums[i]);
                subsets.add(curList);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
