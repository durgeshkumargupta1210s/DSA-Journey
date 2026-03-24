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
    static int sum;
    public TreeNode convertBST(TreeNode root) {
        inorder1(root);
        inorder(root);
        return root;
    }
    public void inorder1(TreeNode root){
        if(root==null){
        return ;
        }

        inorder1(root.left);
        sum+=root.val;
        inorder1(root.right);
    }
    public void inorder(TreeNode root){
        if(root==null){
        return ;
        }

        inorder(root.left);
        int temp=root.val;
        root.val=sum;
        sum-=temp;
        inorder(root.right);
    }

   

}