package com.leetcode.problems;

public class ValidPalindrome {

    public boolean checkPalindrome(String s) {
       String sLower =  s.toLowerCase();
       int l = 0, r = s.length()-1;

       while(l < r) {
           char leftChar = sLower.charAt(l);
           char rightChar = sLower.charAt(r);
           if(!Character.isLetterOrDigit(leftChar)) {
               l++;
               continue;
           }


           if(!Character.isLetterOrDigit(rightChar)) {
               r--;
               continue;
           }

           if(leftChar != rightChar)
                return false;

           l++;
           r--;
       }
        return true;
    }
    public static void main(String[] args) {

    }
}
