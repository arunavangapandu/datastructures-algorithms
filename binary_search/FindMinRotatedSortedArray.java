package binary_search;

public class FindMinRotatedSortedArray {
    
    // Problem: Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    // You must write an algorithm that runs in O(log n) time.

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than right element, 
            // then the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // If mid element is less than or equal to right element,
            // then the minimum is in the left half (including mid)
            else {
                right = mid;
            }
        }
        
        // When left == right, we found the minimum
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinRotatedSortedArray solution = new FindMinRotatedSortedArray();
        
        // Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test Case 1: " + solution.findMin(nums1)); // Expected: 1

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test Case 2: " + solution.findMin(nums2)); // Expected: 0
        
        // Test Case 3
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Test Case 3: " + solution.findMin(nums3)); // Expected: 11
    }
}

