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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
        
    }
    int idx=0;
    public TreeNode build(int [] preorder, int upperbound){
      if(idx==preorder.length || preorder[idx]>upperbound){
        return null;
      } 

      TreeNode root=new TreeNode(preorder[idx++]);
      root.left=build(preorder,root.val);
      root.right=build(preorder,upperbound);
      return root;


    }
}