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
    
    // Stores the minimum difference found so far
    int diff = Integer.MAX_VALUE;
    
    // Keeps track of the previous node in inorder traversal
    TreeNode prev = null;

    // Main function to calculate minimum absolute difference in BST
    public int getMinimumDifference(TreeNode root) {
        
        // Perform inorder traversal
        inorder(root);
        
        // Return the minimum difference
        return diff;
    }

    // Inorder traversal (Left → Root → Right)
    public void inorder(TreeNode root) {
        
        // Base case: if node is null, return
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Process current node
        // In BST, inorder traversal gives sorted order
        if (prev != null) {
            // Calculate difference between current and previous node
            diff = Math.min(diff, root.val - prev.val);
        }

        // Update previous node to current
        prev = root;

        // Traverse right subtree
        inorder(root.right);
    }
}