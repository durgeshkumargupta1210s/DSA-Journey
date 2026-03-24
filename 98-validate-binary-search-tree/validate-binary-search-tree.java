/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /**
     * Main function to validate if a binary tree is a BST.
     * 
     * Approach:
     * We use range validation:
     * Every node must lie within a valid (min, max) range.
     */
    public boolean isValidBST(TreeNode root) {

        // Initial range is (-∞, +∞)
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Recursive helper function to validate BST.
     * 
     * @param root current node
     * @param min  lower bound (all nodes must be > min)
     * @param max  upper bound (all nodes must be < max)
     */
    public boolean isBST(TreeNode root, long min, long max) {

        // Base case: empty tree is valid BST
        if (root == null) {
            return true;
        }

        /**
         * Check current node validity:
         * If node violates the allowed range → NOT BST
         */
        if (root.val <= min || root.val >= max) {
            return false;
        }

        /**
         * Recursive validation:
         * 
         * Left subtree:
         * - Values must be less than current node
         * - Range becomes (min, root.val)
         * 
         * Right subtree:
         * - Values must be greater than current node
         * - Range becomes (root.val, max)
         */
        boolean leftBST = isBST(root.left, min, root.val);
        boolean rightBST = isBST(root.right, root.val, max);

        /**
         * Tree is valid BST only if both subtrees are valid
         */
        return leftBST && rightBST;
    }
}