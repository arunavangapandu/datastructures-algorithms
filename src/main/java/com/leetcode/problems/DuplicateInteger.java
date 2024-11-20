package com.leetcode.problems;

import java.util.HashMap;

public class DuplicateInteger {

        public boolean hasDuplicate(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])){
                    return true;
                }
                map.put(nums[i], 1);
            }
            return false;
        }

    public static void main(String[] args) {
        System.out.println(new DuplicateInteger().hasDuplicate(new int[] {1,2,3,3}));
        System.out.println(new DuplicateInteger().hasDuplicate(new int[] {1,2,3,4 }));

    }

    }


