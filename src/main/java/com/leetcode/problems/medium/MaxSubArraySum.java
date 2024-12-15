package com.leetcode.problems.medium;

public class MaxSubArraySum {
    public int maxSumSubarray(int[] nums, int k) {
        int n = nums.length;
        
        // Calculate the sum of the first 'k' elements
        int maxSum = 0, currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        maxSum = currentSum; // Store the initial sum
        
        // Slide the window over the remaining elements
        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k]; // Slide the window
            maxSum = Math.max(maxSum, currentSum); // Update maxSum if needed
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArraySum solution = new MaxSubArraySum();
        
        // Example 1
        int[] nums1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        System.out.println(solution.maxSumSubarray(nums1, k1)); // Output: 9
        
        // Example 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println(solution.maxSumSubarray(nums2, k2)); // Output: 9
    }
}
