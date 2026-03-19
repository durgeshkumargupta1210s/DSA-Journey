/**
 * Definition for a binary tree node.
 * Each node contains:
 *  - value
 *  - reference to left child
 *  - reference to right child
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // Global variable to store the maximum path sum
    static int maxsum;

    /**
     * Main function to calculate maximum path sum in the binary tree.
     * 
     * Path can start and end at ANY node.
     */
    public int maxPathSum(TreeNode root) {

        // Initialize with smallest possible value
        maxsum = Integer.MIN_VALUE;

        // Start DFS traversal
        solve(root);

        return maxsum;
    }

    /**
     * Helper function:
     * Returns the maximum "single path sum" starting from current node.
     * 
     * Important:
     * - This function returns ONLY one side (either left or right),
     *   because path going up cannot split into two directions.
     */
    public static int solve(TreeNode root){

        // Base case: null node contributes 0
        if(root == null){
            return 0;
        }

        // Recursively compute left and right subtree sums
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        // Value of current node alone
        int rootval = root.val;

        /**
         * Case 1: Path passing through current node (both sides included)
         * This is a "V-shaped path"
         */
        int finals = leftSum + rightSum + root.val;

        /**
         * Case 2: Path continues in one direction (left OR right)
         */
        int either = Math.max(leftSum, rightSum) + root.val;

        /**
         * Update global maximum considering all possibilities:
         * 1) Only current node
         * 2) Path passing through node (left + right)
         * 3) Path going in one direction
         */
        maxsum = Math.max(maxsum,
                    Math.max(rootval,
                        Math.max(finals, either)));

        /**
         * Return value:
         * Only one side can be returned (no splitting allowed upward)
         */
        return Math.max(rootval, either);
    }
}