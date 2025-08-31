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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        int current = root.val;

        // If both p and q are smaller → LCA lies in left subtree
        if (current > p.val && current > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are greater → LCA lies in right subtree
        if (current < p.val && current < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Otherwise, root is the split point → LCA found
        return root;
    }
}
