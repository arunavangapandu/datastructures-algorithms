package com.sorting;

import java.util.Arrays;

public class InsertionSort {

    private int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j+1] < arr[j]) {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
       int[] result = new InsertionSort().insertionSort(new int[] {18, 3, 40, 6, 51, 22});
        System.out.println(Arrays.toString(result));
    }
}
