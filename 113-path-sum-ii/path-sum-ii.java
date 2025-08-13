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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        sumPath(root,targetSum,result,new ArrayList<>());
        return result;   
    }
    public static void sumPath(TreeNode root, int target,List<List<Integer>> result,List<Integer>path ){
        if(root==null){
            return;
        }
        path.add(root.val);
        target-=root.val;
        if(root.left==null && root.right==null && target==0){
            result.add(new ArrayList(path));
        }
        else{
        sumPath(root.left,target,result,path);
        sumPath(root.right,target,result,path);
        }
        path.remove(path.size()-1);// backtracking
        
    }
}