/**
 * Definition for a binary tree node.
 * Each node contains:
 *  - an integer value
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
     * Function to calculate the diameter of a binary tree.
     * 
     * Diameter = number of edges in the longest path between any two nodes.
     * 
     * The longest path can be:
     * 1) Completely in left subtree
     * 2) Completely in right subtree
     * 3) Passing through the current node
     */
    public int diameterOfBinaryTree(TreeNode root) {

        // Base case: if tree is empty, diameter is 0
        if(root == null){
            return 0;
        }

        // Recursively calculate diameter of left subtree
        int leftDiameter = diameterOfBinaryTree(root.left);

        // Recursively calculate diameter of right subtree
        int rightDiameter = diameterOfBinaryTree(root.right);

        /**
         * Diameter passing through current node
         * = height of left subtree + height of right subtree + 2 edges
         */
        int selfDiameter = height(root.left) + height(root.right) + 2;

        /**
         * Final diameter will be the maximum among:
         * 1) Diameter of left subtree
         * 2) Diameter of right subtree
         * 3) Diameter passing through current node
         */
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }


    /**
     * Function to calculate height of a binary tree.
     * Height = number of edges in the longest path from node to leaf.
     */
    public static int height(TreeNode root){

        // Base case: height of empty tree is -1
        if(root == null){
            return -1;
        }

        // Recursively compute height of left subtree
        int leftHeight = height(root.left);

        // Recursively compute height of right subtree
        int rightHeight = height(root.right);

        // Height of current node = max(leftHeight, rightHeight) + 1
        return Math.max(rightHeight, leftHeight) + 1;
    }
}