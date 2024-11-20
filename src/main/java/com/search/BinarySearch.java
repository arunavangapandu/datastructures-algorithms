package com.search;

public class BinarySearch {

    public static Integer binarySearch(int[] arr, int item) {
        int low = 0;                            // ①
        int high = arr.length - 1;             // ②

        while (low <= high) {                   // ③
            int mid = (low + high) / 2;        // ④
            int guess = arr[mid];
            if (guess == item) {               // ⑤
                return mid;
            } else if (guess > item) {         // ⑥
                high = mid - 1;
            } else {                            // ⑦
                low = mid + 1;
            }
        }
        return null;                           // ⑧
    }

    public static void main(String[] args) {
        int[] myList = {1, 3, 5, 7, 9};        // ⑨

        System.out.println(binarySearch(myList, 3));  // => 1  ⑩
        System.out.println(binarySearch(myList, -1)); // => null ⑪
    }
}
