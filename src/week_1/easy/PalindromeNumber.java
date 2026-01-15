package week_1.easy;

import java.util.Arrays;

public class PalindromeNumber {
    // Given an integer x, return true if x is a palindrome, and false otherwise.
    // Example 1:
    // Input: x = 121
    // Output: true
    // Explanation: 121 reads as 121 from left to right and from right to left.
    // Example 2:
    // Input: x = -121
    // Output: false
    // Explanation: From left to right, it reads -121. From right to left, it
    // becomes 121-.
    // Therefore it is not a palindrome.
    // Example 3:
    // Input: x = 10
    // Output: false
    // Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-123));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int inputNum) {
        if (inputNum < 0 || (inputNum % 10 == 0 && inputNum != 0)) {
            return false;
        }
        int reverseNum = 0;
        int lastDigit = 0;
        int target = inputNum;
        while (inputNum >= 1) {
            lastDigit = inputNum % 10;
            reverseNum = (reverseNum * 10) + lastDigit;
            inputNum = inputNum / 10;
        }
        return target == reverseNum;
    }

}
