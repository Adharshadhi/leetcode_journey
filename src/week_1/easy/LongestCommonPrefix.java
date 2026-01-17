package week_1.easy;

public class LongestCommonPrefix {
    // Write a function to find the longest common prefix string amongst an array of
    // strings.
    // If there is no common prefix, return an empty string "".
    // Example 1:
    // Input: strs = ["flower","flow","flight"]
    // Output: "fl"
    // Example 2:
    // Input: strs = ["dog","racecar","car"]
    // Output: ""
    // Explanation: There is no common prefix among the input strings.
    // Constraints:
    // 1 <= strs.length <= 200
    // 0 <= strs[i].length <= 200
    // strs[i] consists of only lowercase English letters if it is non-empty.
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    }

    public static String longestCommonPrefix(String[] strs) {
        int prefixCounter = strs[0].length();
        int tempTracker = 0;
        for (int i = 1; i < strs.length; i++) {
            tempTracker = 0;
            int lowestSize = (strs[0].length() > strs[i].length())
                    ? strs[i].length()
                    : strs[0].length();
            for (int j = 0; j < lowestSize; j++) {
                if (strs[i].charAt(j) == strs[0].charAt(j)) {
                    tempTracker++;
                } else {
                    break;
                }
            }
            if (tempTracker < prefixCounter) {
                prefixCounter = tempTracker;
            }
        }
        return prefixCounter == 0 ? "" : strs[0].substring(0, prefixCounter);
    }

}
