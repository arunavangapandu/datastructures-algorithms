package com.recursion;

import com.search.BinarySearch;

public class BinarySearchRecursion {

    public int binarySearch(int[] arr, int target, int low, int high) {

        //Base case
        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;

        if(arr[mid] == target) {
            return mid;
        }
        if(arr[mid] < target){
            low = mid + 1;
            return binarySearch(arr, target, low, high);
        }

        return binarySearch(arr, target, low, mid-1);
        }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 8};
        System.out.println(new BinarySearchRecursion().
                binarySearch(arr, 5, 0, arr.length-1));
    }
}
