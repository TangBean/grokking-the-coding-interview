package p10.subsets;

import java.util.*;

class SubsetsAns {

    public static List<List<Integer>> findSubsetsAns(int[] nums) {
        List<List<Integer>> SubsetsAns = new ArrayList<>();
        // start by adding the empty subset
        SubsetsAns.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing SubsetsAns and insert the current number in them to create new SubsetsAns
            int n = SubsetsAns.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(SubsetsAns.get(i));
                set.add(currentNumber);
                SubsetsAns.add(set);
            }
        }
        return SubsetsAns;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetsAns.findSubsetsAns(new int[] { 1, 3 });
        System.out.println("Here is the list of SubsetsAns: " + result);

        result = SubsetsAns.findSubsetsAns(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of SubsetsAns: " + result);
    }
}
