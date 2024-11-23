package com.leetcode.problems;

public class ReverseString {

    public String reverseString(String input) {
        int n = input.length();
        char[] charArr = new char[n];
        for(int i = n-1, j = 0; i >= 0 && j < n; i--, j++) {
            charArr[j] = input.charAt(i);
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("hello"));
    }
}
