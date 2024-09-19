package com.sorting;

public class SmallestElement {

    public  int findSmallest(int[] arr) {
        int smallestElement = arr[0];
        int smallestIndex = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < smallestElement) {
                smallestElement = arr[i];
                smallestIndex = i;
            }
        }
        return smallestElement;

    }

    public static void main(String[] args) {
        System.out.println(new SmallestElement().findSmallest(new int[] {2, 6,8, 9, 3, 4}));
    }
}
