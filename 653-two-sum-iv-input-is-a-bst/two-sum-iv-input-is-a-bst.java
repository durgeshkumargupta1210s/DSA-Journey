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
    List<Integer> list=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
       preorder(root);  
       int i=0;
       int j=list.size()-1;
       while(i<j){
        int sum=list.get(i)+list.get(j);
        if(sum==k){
            return true;
        }
        else if(sum>k){
            j--;
        }
        else{
            i++;
        }
       }
       return false;
    }
    public void preorder(TreeNode root ){
        if(root==null){
            return ;
        }
        preorder(root.left);
        list.add(root.val);
        preorder(root.right);

    }
}