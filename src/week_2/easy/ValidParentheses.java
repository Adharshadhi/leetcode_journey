package week_2.easy;

import java.util.Stack;

public class ValidParentheses {
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and
    // ']',
    // determine if the input string is valid.

    // An input string is valid if:

    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.
    // Every close bracket has a corresponding open bracket of the same type.

    // Example 1:

    // Input: s = "()"

    // Output: true

    // Example 2:

    // Input: s = "()[]{}"

    // Output: true

    // Example 3:

    // Input: s = "(]"

    // Output: false

    // Example 4:

    // Input: s = "([])"

    // Output: true

    // Example 5:

    // Input: s = "([)]"

    // Output: false

    // Constraints:

    // 1 <= s.length <= 104
    // s consists of parentheses only '()[]{}'.

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("{[]}")); // true
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> parenthesesStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentBracket = s.charAt(i);
            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                parenthesesStack.push(s.charAt(i));
            } else {
                if (parenthesesStack.isEmpty() || getMatchingBracket(parenthesesStack.pop()) != currentBracket) {
                    return false;
                }
            }
        }
        return parenthesesStack.size() == 0;
    }

    private static char getMatchingBracket(char bracket) {
        return switch (bracket) {
            case '(' -> ')';
            case '{' -> '}';
            default -> ']';
        };
    }

}
