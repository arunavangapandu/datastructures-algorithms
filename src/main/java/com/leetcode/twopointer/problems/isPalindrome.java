package com.leetcode.twopointer.problems;

import java.util.Locale;

public class isPalindrome {

   /* Time complexity is O(n)
    Space Complexity is O(1)*/

        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                char leftChar = Character.toLowerCase(s.charAt(left));
                char rightChar = Character.toLowerCase(s.charAt(right));

                if (!Character.isLetterOrDigit(leftChar)) {
                    left++;
                } else if (!Character.isLetterOrDigit(rightChar)) {
                    right--;
                } else if (leftChar != rightChar) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;

        }


    public static void main(String[] args) {
//        System.out.println(new isPalindrome().isPalindrome("rac_e Car"));
  System.out.println(new isPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new isPalindrome().isPalindrome(" "));
//        System.out.println(new isPalindrome().isPalindrome("race  a car"));
    }
}
