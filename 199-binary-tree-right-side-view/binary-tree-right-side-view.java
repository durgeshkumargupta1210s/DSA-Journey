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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        rightSide(root,1,list);
        return list;
        
    }
    int maxDepth=0;
    public  void rightSide(TreeNode root, int currentLevel,List<Integer> list){
        if(root==null){
            return;
        }
        if(maxDepth<currentLevel){
            list.add(root.val);
            maxDepth=currentLevel;
        }
        rightSide(root.right,currentLevel+1,list);
        rightSide(root.left,currentLevel+1,list);
    }
}