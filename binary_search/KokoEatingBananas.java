package binary_search;

public class KokoEatingBananas {
    
    // Problem: Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
    // The guards have gone and will come back in h hours.
    // Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    // If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    // Return the minimum integer k such that she can eat all the bananas within h hours.

    public int minEatingSpeed(int[] piles, int h) {
        // TODO: Implement Binary Search Solution
        
        return 0;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        
        // Test Case 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Test Case 1: " + solution.minEatingSpeed(piles1, h1)); // Expected: 4

        // Test Case 2
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Test Case 2: " + solution.minEatingSpeed(piles2, h2)); // Expected: 30
        
        // Test Case 3
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Test Case 3: " + solution.minEatingSpeed(piles3, h3)); // Expected: 23
    }
}

