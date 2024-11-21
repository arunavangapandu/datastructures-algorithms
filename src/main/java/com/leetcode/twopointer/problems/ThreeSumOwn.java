package com.leetcode.twopointer.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSumOwn {

//    public List<List<Integer>> findingTriplets(int[] nums) {
//        Arrays.sort(nums);
//        int length = nums.length;
//        List<List<Integer>> resultSet = new ArrayList<>();
//
//        for(int i = 0; i < length; i++) {
//            int left = i+1, right = length-1, sum = 0;
//            List<Integer> triplets = new ArrayList<>();
//            while(left <= right) {
//                sum = nums[i] + nums[left] + nums[right];
//                if(sum == 0) {
//                    triplets.add(nums[i]);
//                    triplets.add(nums[left]);
//                    triplets.add(nums[right]);
//                } else if(sum < 0) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//            resultSet.add(triplets);
//        }
//        return resultSet;
//    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num.length < 3) {
            return result;
        }

        Arrays.sort(num);

        for (int i = 0 ; i < num.length - 2 ; i++) {
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;

            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);

                    while (left < right && num[left] == num[left+1]){
                        left++;
                    }
                    while (left < right && num[right] == num[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
       List<List<Integer>> result = new ThreeSumOwn().threeSum(new int[]{-1,0,1,2,-1,-4});
        for(int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for(int j= 0; j < list.size(); j++) {
                System.out.print(" " + list.get(j) + " , " + " ");
            }
        }
    }
}
