import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRange {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * checks if there is any node in the BST that falls within the range [low, high].
     * 
     * Assumptions:
     * 1. The input tree is a Binary Search Tree (BST).
     * 2. The range is inclusive [low, high].
     * 3. Returns true if AT LEAST ONE node exists in the range.
     */
    public static boolean isRangePresent(TreeNode root, int low, int high) {
        if (root == null) {
            return false;
        }

        // If current node is in range, we found one. Return true.
        if (root.val >= low && root.val <= high) {
            return true;
        }

        // If current value is greater than high, the potential range values must be in the left subtree.
        if (low < root.val) {
            return isRangePresent(root.left, low, high);
        }

        // If current value is less than low, the potential range values must be in the right subtree.
        if (high > root.val) {
            return isRangePresent(root.right, low, high);
        }

        return false;
    }

    // Helper to insert nodes into BST for testing
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        // Case 1: User Example
        // Root 102, Left 98, Right 108
        TreeNode root1 = new TreeNode(102);
        root1.left = new TreeNode(98);
        root1.right = new TreeNode(108);

        int low1 = 98;
        int high1 = 105;
        
        System.out.println("Test Case 1 (User Example):");
        System.out.println("Tree: {102, L:98, R:108}");
        System.out.println("Range: [" + low1 + ", " + high1 + "]");
        System.out.println("Exists in range? " + isRangePresent(root1, low1, high1));
        System.out.println("--------------------------------------------------");

        // Case 2: Bigger Tree
        // Structure:
        //        50
        //      /    \
        //    30      70
        //   /  \    /  \
        //  20  40  60  80
        TreeNode root2 = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) root2 = insert(root2, v);

        System.out.println("Test Case 2 (Bigger Tree):");
        // Sub-case A: Range matches internal nodes (35-45) -> Matches 40
        System.out.println("Range [35, 45] (Matches 40): " + isRangePresent(root2, 35, 45)); // True
        
        // Sub-case B: Range matches nothing (matches gap 41-49)
        System.out.println("Range [41, 49] (Matches None): " + isRangePresent(root2, 41, 49)); // False
        
        // Sub-case C: Range lower than min (5-15)
        System.out.println("Range [5, 15] (Too Low): " + isRangePresent(root2, 5, 15)); // False
        
        // Sub-case D: Range higher than max (90-100)
        System.out.println("Range [90, 100] (Too High): " + isRangePresent(root2, 90, 100)); // False

        // Sub-case E: Wide range covering multiple (55-65) -> Matches 60
        System.out.println("Range [55, 65] (Matches 60): " + isRangePresent(root2, 55, 65)); // True

        System.out.println("--------------------------------------------------");

        // Case 3: Edge Cases
        System.out.println("Test Case 3 (Edge Cases):");
        
        // Null tree
        System.out.println("Null Tree: " + isRangePresent(null, 10, 20)); // False
        
        // Single Node Tree (Value 10)
        TreeNode single = new TreeNode(10);
        // Range hits exactly
        System.out.println("Single Node(10), Range [10, 10]: " + isRangePresent(single, 10, 10)); // True
        // Range misses low
        System.out.println("Single Node(10), Range [0, 5]: " + isRangePresent(single, 0, 5)); // False
        // Range misses high
        System.out.println("Single Node(10), Range [15, 20]: " + isRangePresent(single, 15, 20)); // False
    }
}


