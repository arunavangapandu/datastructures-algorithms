package com.sorting;

import java.util.Arrays;

public class SelectionSort {

    public int[] selectionSort(int[] arr) {
        int[] sortedArray = new int[arr.length];
        int[] copiedArr = Arrays.copyOf(arr, arr.length);
        for(int i = 0; i < copiedArr.length; i++) {
           int smallestIndex = findSmallest(copiedArr);
           sortedArray[i] = copiedArr[smallestIndex];
           copiedArr[smallestIndex] = Integer.MAX_VALUE;
        }

        return sortedArray;
    }
    public  int findSmallest(int[] arr) {
        int smallestElement = arr[0];
        int smallestIndex = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < smallestElement) {
                smallestElement = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;

    }

    public static void main(String[] args) {
        //System.out.println(new SelectionSort().findSmallest(new int[] {2, 6,8, 9, 3, 4}));
        System.out.println(Arrays.toString(new SelectionSort().selectionSort(new int[] {4, 8, 9, 3,4,2,1})));
    }
}
