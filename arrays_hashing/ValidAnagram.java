package arrays_hashing;

import java.util.*;

public class ValidAnagram {
    
    // Problem: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    // An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    // typically using all the original letters exactly once.

    public boolean isAnagram(String s, String t) {
            if(s == null || t == null)
                return false;
            if(s.length() != t.length()){
                return false;
            }
            // Create Frequency Map
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for(char c: s.toCharArray()){
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
    
            // Loop through string t and lookup in frequency map
            for(char c: t.toCharArray()) {
                if(!frequencyMap.containsKey(c)) {
                    return false; 
                } else {
                    int count = frequencyMap.get(c);
                    if(count == 0) {
                        return false;
                    }
                    frequencyMap.put(c, count-1);    
                }
            }
    
            // Loop through map and verify the count values are all zeroes
            for(int count: frequencyMap.values()) {
                    if(count > 0) {
                        return false;
                    }
            } 
            return true;
            
        }
    

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        
        // Test Case 1
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Test Case 1: " + solution.isAnagram(s1, t1)); // Expected: true

        // Test Case 2
        String s2 = "rat", t2 = "car";
        System.out.println("Test Case 2: " + solution.isAnagram(s2, t2)); // Expected: false
    }
}

