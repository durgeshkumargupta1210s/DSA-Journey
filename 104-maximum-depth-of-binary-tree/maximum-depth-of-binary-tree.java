/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;            // value stored in the node
 *     TreeNode left;      // reference to the left child
 *     TreeNode right;     // reference to the right child
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
    public int maxDepth(TreeNode root) {

        // Base case:
        // If the node is null, the depth is 0
        if(root == null){
            return 0;
        }

        // Recursively calculate the depth of the left subtree
        int lh = maxDepth(root.left);

        // Recursively calculate the depth of the right subtree
        int rh = maxDepth(root.right);

        // The depth of the current node is:
        // 1 (for current node) + maximum depth of its subtrees
        return Math.max(lh, rh) + 1;
    }
}