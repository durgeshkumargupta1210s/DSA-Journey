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
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	    }

	    public TreeNode build(int[] preorder,int plo, int phi,int[] inorder, int ilo, int ihi){
	        if(ilo>ihi || plo > phi){
	            return null;
	        }
	        TreeNode nn = new TreeNode();
	        nn.val = preorder[plo];
	        int idx = Search(inorder, ilo, ihi, preorder[plo]);
	        int ne = idx - ilo;
	        nn.left = build(preorder, plo+1, plo+ne, inorder, ilo, ilo+ne);
	        nn.right = build(preorder,plo+ne+1, phi, inorder, ilo+ne+1, ihi  );
	        return nn;
	    }

	    public int Search(int[] arr, int ei, int si, int target){
	        for(int i = ei; i<=si; i++){
	            if(arr[i] == target){
	                return i;
	            }
	        }
	        return 0;
	    }
	}