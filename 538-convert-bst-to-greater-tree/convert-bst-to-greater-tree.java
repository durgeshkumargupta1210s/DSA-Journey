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

    // Stores total sum of all nodes initially,
    // then used to update node values
    static int sum;

    /**
     * Converts BST into Greater Tree
     *
     * Idea:
     * Step 1: Calculate total sum of all nodes
     * Step 2: Update each node using running sum
     */
    public TreeNode convertBST(TreeNode root) {

        // Step 1: Compute total sum of BST
        inorder1(root);

        // Step 2: Update each node value
        inorder(root);

        return root;
    }

    /**
     * First inorder traversal:
     * Calculates total sum of all nodes
     */
    public void inorder1(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder1(root.left);

        // Accumulate total sum
        sum += root.val;

        inorder1(root.right);
    }

    /**
     * Second inorder traversal:
     * Updates each node value
     *
     * Logic:
     * - Replace node value with current total sum
     * - Subtract original value from sum
     */
    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        int temp = root.val;

        // Assign new value (greater sum)
        root.val = sum;

        // Reduce sum for next nodes
        sum -= temp;

        inorder(root.right);
    }
}