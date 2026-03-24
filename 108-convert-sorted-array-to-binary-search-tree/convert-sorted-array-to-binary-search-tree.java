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
     * Converts a sorted array into a height-balanced BST.
     *
     * Key Idea:
     * Always pick the middle element as root
     * → ensures balanced tree (left ≈ right)
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        // Start recursion on full array
        return createTree(nums, 0, nums.length - 1);
    }

    /**
     * Recursive function to build BST
     *
     * @param nums  sorted array
     * @param start starting index
     * @param end   ending index
     */
    public TreeNode createTree(int[] nums, int start, int end) {

        /**
         * Base Case:
         * If range is invalid → no node
         */
        if (start > end) {
            return null;
        }

        /**
         * Choose middle element as root
         * This ensures height-balanced BST
         */
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        /**
         * Left subtree:
         * elements before mid
         */
        root.left = createTree(nums, start, mid - 1);

        /**
         * Right subtree:
         * elements after mid
         */
        root.right = createTree(nums, mid + 1, end);

        return root;
    }
}