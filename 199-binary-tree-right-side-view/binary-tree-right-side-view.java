/**
 * Definition for a binary tree node.
 * Each node contains:
 *  - value
 *  - reference to left child
 *  - reference to right child
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    /**
     * Function to return the right side view of a binary tree.
     * 
     * Right view = nodes visible when the tree is viewed from the right side.
     * 
     * Approach: Level Order Traversal (BFS)
     */
    public List<Integer> rightSideView(TreeNode root) {

        // List to store result
        List<Integer> result = new ArrayList<>();

        /**
         * Base case:
         * If tree is empty → return empty list
         */
        if (root == null) return result;

        /**
         * Queue for BFS traversal
         */
        Queue<TreeNode> q = new LinkedList<>();

        // Start with root node
        q.add(root);

        /**
         * Process level by level
         */
        while (!q.isEmpty()) {

            // Number of nodes at current level
            int size = q.size();

            /**
             * Traverse all nodes of current level
             */
            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                /**
                 * If this is the last node of the level,
                 * it represents the rightmost node → add to result
                 */
                if (i == size - 1) {
                    result.add(node.val);
                }

                /**
                 * Add left child (if exists)
                 */
                if (node.left != null) {
                    q.add(node.left);
                }

                /**
                 * Add right child (if exists)
                 */
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return result;
    }
}