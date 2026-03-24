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
     * Inserts a value into a Binary Search Tree (BST)
     * and returns the updated root.
     *
     * Key Property of BST:
     * left subtree < root < right subtree
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {

        /**
         * Base Case:
         * If we reach a null position, this is the correct
         * place to insert the new node.
         */
        if (root == null) {
            return new TreeNode(val);
        }

        /**
         * If value is greater than current node,
         * it must go to the right subtree.
         */
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        /**
         * If value is smaller than current node,
         * it must go to the left subtree.
         */
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        /**
         * Note:
         * If val == root.val → we do nothing.
         * (Assuming BST does NOT allow duplicates)
         */

        /**
         * Return the root after insertion.
         * This ensures parent nodes correctly link
         * to updated subtrees.
         */
        return root;
    }
}