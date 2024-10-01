package com.sorting;

import java.util.Arrays;

public class QuickSort {

   // [1,2,6, 4,7,9]

    public int[] quickSort(int[] arr){
        if(arr.length <= 1) {
            return arr;
        }

        int pivot = arr[0];

        // Create 2 arrays to hold elements less than pivot and greater than pivot
        int[] leftSubArray = new int[arr.length-1];
        int[] rightSubArray = new int[arr.length-1];

        int leftIndex = 0;
        int rightIndex = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < pivot) {
                leftSubArray[leftIndex] = arr[i];
                leftIndex++;

            } else {
                rightSubArray[rightIndex] = arr[i];
                rightIndex++;
            }
        }

        // Create the final left and right arrays with the correct size
        leftSubArray = Arrays.copyOf(leftSubArray, leftIndex);
        rightSubArray = Arrays.copyOf(rightSubArray, rightIndex);
        
        leftSubArray = quickSort(leftSubArray);
        rightSubArray = quickSort(rightSubArray);

        // Merge sorted left sub-array, pivot, and sorted right sub-array
        int[] result = new int[leftSubArray.length + 1 + rightSubArray.length];
        System.arraycopy(leftSubArray, 0, result, 0, leftSubArray.length);
        result[leftSubArray.length] = pivot;
        System.arraycopy(rightSubArray, 0, result, leftSubArray.length + 1, rightSubArray.length);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 10, 7, 6, 5};
        System.out.println(Arrays.toString(new QuickSort().quickSort(arr)));
    }
}
