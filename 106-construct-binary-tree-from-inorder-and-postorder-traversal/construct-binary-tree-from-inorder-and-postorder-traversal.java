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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1, postorder ,0, postorder.length-1);
        
    }
    public TreeNode build(int[] inorder, int ilo,int ihi, int[] postorder, int plo,int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }

        TreeNode nn=new TreeNode();
        nn.val=postorder[phi];
        int idx=Search( inorder,  ilo,  ihi,postorder[phi]);
        int ne=idx-ilo;

        nn.left=build(inorder,ilo,ilo+ne,postorder,plo,plo+ne-1);
        nn.right=build(inorder, ilo+ne+1, ihi, postorder,plo+ne,phi-1);

        return nn;
    }
    public int Search(int [] inorder, int start, int end, int target){
        for(int i=start; i<=end; i++){
           if(inorder[i]==target){
            return i;
           }
        }
        return -1;
    }
}