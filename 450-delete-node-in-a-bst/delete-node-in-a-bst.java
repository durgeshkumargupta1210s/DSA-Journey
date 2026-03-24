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
     * Deletes a node with given key from BST and returns updated root.
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        /**
         * Base Case:
         * If tree is empty → nothing to delete
         */
        if (root == null) {
            return null;
        }

        /**
         * Step 1: Traverse the tree to find the node
         */
        if (key > root.val) {
            // Move to right subtree
            root.right = deleteNode(root.right, key);
        } 
        else if (key < root.val) {
            // Move to left subtree
            root.left = deleteNode(root.left, key);
        }

        /**
         * Step 2: Node found → handle deletion
         */
        else {

            /**
             * Case 1: Node has NO left child
             * → Replace node with right child
             */
            if (root.left == null) {
                return root.right;
            }

            /**
             * Case 2: Node has NO right child
             * → Replace node with left child
             */
            if (root.right == null) {
                return root.left;
            }

            /**
             * Case 3: Node has TWO children
             * 
             * Strategy:
             * - Find inorder successor (smallest in right subtree)
             * - Replace current node value with successor value
             * - Delete successor from right subtree
             */
            TreeNode rightmin = findmin(root.right);

            // Replace current node value
            root.val = rightmin.val;

            // Delete duplicate node from right subtree
            root.right = deleteNode(root.right, rightmin.val);
        }

        /**
         * Return updated root after deletion
         */
        return root;
    }

    /**
     * Helper function to find minimum node
     * (leftmost node in BST)
     */
    public TreeNode findmin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}