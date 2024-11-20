package com.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramSolutionBruteForce {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List to hold the final groups of anagrams
        List<List<String>> result = new ArrayList<>();

        // Boolean array to keep track of visited strings
        boolean[] visited = new boolean[strs.length];

        // Iterate over each string
        for (int i = 0; i < strs.length; i++) {
            // Skip if this string has already been grouped
            if (visited[i]) continue;

            // Create a new group starting with this string
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            // Compare this string with every other string
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && areAnagrams(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true; // Mark as grouped
                }
            }

            // Add the group to the result
            result.add(group);
        }

        return result;
    }

    // Helper method to check if two strings are anagrams using character counts
    private boolean areAnagrams(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (int j = 0; j < t.length(); j++) {
                char c = t.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.getOrDefault(c, 0) - 1);
                }
            }


            for (int value : map.values()) {
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }


    public static void main(String[] args) {
        AnagramSolutionBruteForce bf = new AnagramSolutionBruteForce();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = bf.groupAnagrams(strs);

        // Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
 }

