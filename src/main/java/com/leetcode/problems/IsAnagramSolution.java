package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagramSolution {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);


            // Increment count for character in s
            count.put(charS, count.getOrDefault(charS, 0) + 1);

            // Decrement count for character in t
            count.put(charT, count.getOrDefault(charT, 0) - 1);
        }

        // Check if all counts are 0
        for (int value : count.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        IsAnagramSolution solution = new IsAnagramSolution();

            // Test Case 1: Anagram strings
            String s1 = "listen";
            String t1 = "silent";
            System.out.println("Test Case 1: " + solution.isAnagram(s1, t1));  // Expected: true

            // Test Case 2: Non-anagram strings
            String s2 = "hello";
            String t2 = "world";
            System.out.println("Test Case 2: " + solution.isAnagram(s2, t2));  // Expected: false

        }
  }
