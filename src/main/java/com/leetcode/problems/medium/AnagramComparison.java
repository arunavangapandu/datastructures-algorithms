package com.leetcode.problems.medium;

//Two lists a = ['tea', 'tea', 'act'] and  b = ['ate', 'toe', 'acts'] if each a[0] and b[0] are anagrams of same size and characters are same, add 0 to result array, and add -1 to result array if they are of not equal size strings in a list, and add the count of the different characters to the result array if they are not anagrams.
//        can you provide the solution in java
//Explanation:
//
//        Iterate over both lists: For each pair of strings at the same index, compare their lengths.
//        Unequal Lengths: If the lengths are different, add -1 to the result array.
//        Anagram Check: If the lengths are equal, check if they are anagrams using the isAnagram method.
//        Create a character count map for the first string.
//        Iterate over the second string, decrementing the count for each character in the map.
//        If any count becomes negative or the map is not empty after processing the second string, they are not anagrams.
//        Different Character Count: If they are not anagrams, use the countDifferentChars method to count the different characters.
//        Create a character count map for the first string.
//        Iterate over the second string, decrementing the count for each character.
//        Count the remaining characters in the map and the characters in the second string that were not found in the first.
//        This code efficiently handles the given conditions and provides the correct result for the specified input.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramComparison {
    public static void main(String[] args) {
        String[] a = {"tea", "tea", "act"};
        String[] b = {"ate", "toe", "acts"};

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                result[i] = -1;
            } else {
                if (isAnagram(a[i], b[i])) {
                    result[i] = 0;
                } else {
                    result[i] = countDifferentChars(a[i], b[i]);
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }

    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            charCountMap.put(c, count - 1);
        }

        return true;
    }

    private static int countDifferentChars(String str1, String str2) {
        int count = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            int countInStr1 = charCountMap.getOrDefault(c, 0);
            if (countInStr1 == 0) {
                count++;
            } else {
                charCountMap.put(c, countInStr1 - 1);
            }
        }

        // Add remaining characters in str1 that are not in str2
        for (int value : charCountMap.values()) {
            count += value;
        }

        return count;
    }
}