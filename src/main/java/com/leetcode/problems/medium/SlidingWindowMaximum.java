package com.leetcode.problems.medium;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 8, 7};
        int k = 3;

        List<Integer> result = findSlidingWindowMaximum(arr, k);
        System.out.println("Sliding window maximums: " + result);
    }

    public static List<Integer> findSlidingWindowMaximum(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements as they are not useful
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add the current element index
            deque.offerLast(i);

            // The maximum element for the current window
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }
}
