from typing import List

class Solution:
    """
    Problem: Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
    """
    def containsDuplicate(self, nums: List[int]) -> bool:
        #create set to find duplicates
        seen = set()

        #loop through nums
        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        return False


if __name__ == "__main__":
    solution = Solution()
    
    # Test Case 1
    nums1 = [1, 2, 3, 1]
    print(f"Test Case 1: {solution.containsDuplicate(nums1)}") # Expected: True

    # Test Case 2
    nums2 = [1, 2, 3, 4]
    print(f"Test Case 2: {solution.containsDuplicate(nums2)}") # Expected: False

    # Test Case 3
    nums3 = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    print(f"Test Case 3: {solution.containsDuplicate(nums3)}") # Expected: True

