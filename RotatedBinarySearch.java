package com.fetch.challenge.challenge;

public class RotatedBinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Step 1: Identify which side is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted [left...mid]
                
                // Step 2: Check if target is inside this sorted range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left side
                } else {
                    left = mid + 1;  // Target is in the right side
                }
            } else {
                // Right side is sorted [mid...right]
                
                // Step 2: Check if target is inside this sorted range
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target is in the right side
                } else {
                    right = mid - 1; // Target is in the left side
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        RotatedBinarySearch solver = new RotatedBinarySearch();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solver.search(nums, 0)); // Output: 4
        System.out.println(solver.search(nums, 3)); // Output: -1
    }
}



