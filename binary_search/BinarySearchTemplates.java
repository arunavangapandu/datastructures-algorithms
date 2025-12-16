package binary_search;

public class BinarySearchTemplates {

    /**
     * 1. STANDARD BINARY SEARCH
     * Goal: Find exact target.
     * Loop: while(left <= right)
     * Returns: Index or -1
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 2. LOWER BOUND (First Occurrence / Insert Position)
     * Goal: Find first index where nums[i] >= target.
     * Loop: while(left < right) -> Converges to answer
     * Returns: Index (if target exists, it's first occurrence; if not, it's insert pos)
     */
    public int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length; // Note: right = length (for insert at end)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid; // Possible answer, keep it
            } else {
                left = mid + 1; // Too small, discard mid
            }
        }
        return left;
    }

    /**
     * 3. UPPER BOUND
     * Goal: Find first index where nums[i] > target.
     * Loop: while(left < right)
     */
    public int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) { // Difference: strictly greater
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 4. SQUARE ROOT (Result is the value, not index)
     * Goal: Find max integer k such that k*k <= x.
     * Pattern: "Search on Answer"
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Use division to avoid overflow: mid * mid <= x  ==>  mid <= x / mid
            if (mid <= x / mid) {
                ans = mid;      // mid is valid, try larger
                left = mid + 1;
            } else {
                right = mid - 1; // mid is too big
            }
        }
        return ans;
    }

    /**
     * 5. MIN IN ROTATED SORTED ARRAY
     * Goal: Find the "cliff" or pivot point.
     * Pattern: Comparison with RIGHT neighbor
     */
    public int findMinRotated(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { // Convergence loop
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Min is to right
            } else {
                right = mid;    // Min is left or mid
            }
        }
        return nums[left];
    }

    /**
     * 6. KOKO EATING BANANAS (Search on Solution Space)
     * Goal: Find min speed k.
     * Range: [1, max(piles)]
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000; // Can maximize this based on constraints
        // Or find actual max: for(int p : piles) right = Math.max(right, p);

        int ans = right;
        while (left <= right) {
            int k = left + (right - left) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + k - 1) / k; // Ceil division
            }
            if (hours <= h) {
                ans = k;       // Speed works, try slower
                right = k - 1;
            } else {
                left = k + 1;  // Too slow, need speed
            }
        }
        return ans;
    }
}

