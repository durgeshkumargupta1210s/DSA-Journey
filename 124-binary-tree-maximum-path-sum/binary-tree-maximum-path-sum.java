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
    static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        solve(root);
        return maxSum;
        
    }
    public static int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftSum=solve(root.left);

        int rightSum=solve(root.right);

        // when neither the left nor the right contribute in answer to make maximum path
        int rootAns=root.val;

        // finally got a path having maximum sum
        int finalAns=leftSum+rightSum+root.val;

        // when either left part or right part contribute in the maximum path
        int either=Math.max(leftSum,rightSum)+root.val;

        maxSum=Math.max(maxSum,Math.max(rootAns,Math.max(finalAns,either)));

        return Math.max(either,rootAns);
    }
}