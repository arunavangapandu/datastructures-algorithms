package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int compliment = target - num;
            if(map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            }
            map.put(num, i);
        }
        return new int[]{};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumSolution().twoSum(new int[] {4,5,6}, 10)));
        System.out.println(Arrays.toString(new TwoSumSolution().twoSum(new int[] {3,4,5,6}, 7)));
    }
}
