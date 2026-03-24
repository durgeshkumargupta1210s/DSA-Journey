/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    // Function to find Lowest Common Ancestor (LCA) in a Binary Search Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Case 1: Both nodes lie in the left subtree
        // If both p and q values are smaller than root,
        // then LCA must be in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Case 2: Both nodes lie in the right subtree
        // If both p and q values are greater than root,
        // then LCA must be in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Case 3: Split condition
        // If one node is on the left and the other is on the right,
        // OR one of them is equal to root,
        // then current root is the Lowest Common Ancestor
        return root;
    }
}