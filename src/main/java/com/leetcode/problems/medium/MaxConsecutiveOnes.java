package com.leetcode.problems.medium;

public class MaxConsecutiveOnes {
    private static int findMaxConsecutiveOnes(int[] arr, int k) {
        int max_w = 0;  // Maximum window size
        int num_zeroes = 0;  // Count of zeroes in the current window
        int l = 0;  // Left pointer

        for (int r = 0; r < arr.length; r++) {
            // Expand the window by including the element at `r`
            if (arr[r] == 0) {
                num_zeroes++;
            }

            // Shrink the window if zeroes exceed `k`
            while (num_zeroes > k) {
                if (arr[l] == 0) {
                    num_zeroes--;
                }
                l++;
            }

            // Update the maximum window size
            max_w = Math.max(max_w, r - l + 1);
        }

        return max_w;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(MaxConsecutiveOnes.findMaxConsecutiveOnes(arr, k)); // Output: 6
    }
}
