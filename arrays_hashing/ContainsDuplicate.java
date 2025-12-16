package arrays_hashing;

import java.util.*;

public class ContainsDuplicate {
    
    // Problem: Given an integer array nums, return true if any value appears at least twice in the array,
    // and return false if every element is distinct.
    public boolean containsDuplicate(int[] nums) {

        // Create a set to store the numbers we have seen
        Set<Integer> seen = new HashSet<>();

        // Loop through the array and store it in set
        for(int num:nums) {
            if(seen.contains(num)) {
                return true; // Stop immediately, found a duplicate
            }
            seen.add(num);
        }
        return false;     
    }
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test Case 1: " + solution.containsDuplicate(nums1)); // Expected: true

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test Case 2: " + solution.containsDuplicate(nums2)); // Expected: false
        
        // Test Case 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test Case 3: " + solution.containsDuplicate(nums3)); // Expected: true
    }
}

