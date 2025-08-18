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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        boolean a=isBalanced(root.left);
        boolean b=isBalanced(root.right);
        boolean sb=Math.abs(height(root.left)-height(root.right))<=1;
        return (a && b) && sb;
        
    }

    public static int height(TreeNode root){
        if(root==null){
            return -1;
        }

        int lh=height(root.left);
        int rh=height(root.right);

        return Math.max(lh,rh)+1;
    }
}