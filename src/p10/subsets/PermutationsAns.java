package p10.subsets;

import java.util.*;

public class PermutationsAns {

    public static List<List<Integer>> findPermutationsAns(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> PermutationsAns = new LinkedList<>();
        PermutationsAns.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing PermutationsAns and add the current number to create new PermutationsAns
            int n = PermutationsAns.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = PermutationsAns.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        PermutationsAns.add(newPermutation);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsAns.findPermutationsAns(new int[] { 1, 3, 5 });
        System.out.print("Here are all the PermutationsAns: " + result);
    }
}
