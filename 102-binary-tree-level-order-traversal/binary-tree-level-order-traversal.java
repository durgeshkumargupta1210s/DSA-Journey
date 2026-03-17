/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;            // value stored in the node
 *     TreeNode left;      // reference to left child
 *     TreeNode right;     // reference to right child
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        // List to store the final level order traversal
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: if tree is empty return empty result
        if(root == null){
            return result;
        }

        // Queue used for Breadth First Search (BFS)
        Queue<TreeNode> q = new LinkedList<>();

        // Add root node to the queue to start traversal
        q.add(root);

        // Continue traversal until queue becomes empty
        while(!q.isEmpty()){

            // Number of nodes present at the current level
            int size = q.size();

            // List to store nodes of the current level
            List<Integer> list = new ArrayList<>();

            // Process all nodes of this level
            for(int i = 0; i < size; i++){

                // Remove node from queue
                TreeNode node = q.poll();

                // Add node value to current level list
                list.add(node.val);

                // If left child exists, add it to queue
                if(node.left != null){
                    q.add(node.left);
                }

                // If right child exists, add it to queue
                if(node.right != null){
                    q.add(node.right);
                }
            }

            // After processing the level, add it to result
            result.add(list);
        }

        // Return final level order traversal
        return result;
    }
}