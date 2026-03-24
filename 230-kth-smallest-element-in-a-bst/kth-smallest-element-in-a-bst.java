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

    // Global counter to track remaining nodes to skip
    static int count;

    // Stores the kth smallest value once found
    static int result;

    /**
     * Returns the kth smallest element in BST
     *
     * Key Idea:
     * Inorder traversal of BST gives sorted order.
     */
    public int kthSmallest(TreeNode root, int k) {

        // Initialize counter with k
        count = k;

        // Perform inorder traversal
        inorder(root);

        return result;
    }

    /**
     * Inorder Traversal: Left → Root → Right
     * This visits nodes in ascending order.
     */
    public void inorder(TreeNode root) {

        // Base case
        if (root == null) {
            return;
        }

        // Step 1: Traverse left subtree
        inorder(root.left);

        /**
         * Step 2: Process current node
         * Decrement count for each visited node
         */
        count--;

        /**
         * When count becomes 0,
         * we have found the kth smallest element
         */
        if (count == 0) {
            result = root.val;
            return; // stop further processing
        }

        // Step 3: Traverse right subtree
        inorder(root.right);
    }
}