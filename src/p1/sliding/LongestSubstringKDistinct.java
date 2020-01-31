package p1.sliding;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 *
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 *
 * Example 3:
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.length() < k) {
            return 0;
        }

        int maxLength = 0, windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char cur = str.charAt(windowEnd);
            while (map.size() > k) {
                char startStr = str.charAt(windowStart++);
                if (map.get(startStr) == 1) {
                    map.remove(startStr);
                } else {
                    map.put(startStr, map.get(startStr) - 1);
                }
            }
            if (map.size() == k) {
                maxLength = Math.max(maxLength, windowEnd - windowStart);
            }
            map.put(cur, map.containsKey(cur) ? map.get(cur) + 1 : 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
