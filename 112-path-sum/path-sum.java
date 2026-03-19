/**
 * Definition for a binary tree node.
 * Each node contains:
 *  - value
 *  - reference to left child
 *  - reference to right child
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    /**
     * Function to check if there exists a root-to-leaf path
     * such that the sum of node values equals targetSum.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        /**
         * Base Case 1:
         * If tree is empty → no path exists
         */
        if(root == null){
            return false;
        }

        /**
         * Base Case 2 (Leaf Node):
         * If current node is a leaf (no children),
         * check if remaining target equals current node value
         */
        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }

        /**
         * Recursive Step:
         * Reduce targetSum by current node value
         * and check in left and right subtrees
         */
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        /**
         * If any path (left OR right) satisfies the condition,
         * return true
         */
        return left || right;
    }
}