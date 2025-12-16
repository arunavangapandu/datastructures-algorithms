from typing import List

class Solution:
    """
    Problem: Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    You must write an algorithm that runs in O(log n) time.
    """
    def findMin(self, nums: List[int]) -> int:
        # TODO: Implement Binary Search Solution
        return 0

if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1
    nums1 = [3, 4, 5, 1, 2]
    print(f"Test Case 1: {solution.findMin(nums1)}") # Expected: 1

    # Test Case 2
    nums2 = [4, 5, 6, 7, 0, 1, 2]
    print(f"Test Case 2: {solution.findMin(nums2)}") # Expected: 0

    # Test Case 3
    nums3 = [11, 13, 15, 17]
    print(f"Test Case 3: {solution.findMin(nums3)}") # Expected: 11

