class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        // leaf node, always valid
        if (root.left == null && root.right == null) {
            return true;
        }

        int l = 0, r = 0;

        if (root.left != null) {
            l = root.left.val;
        }

        if (root.right != null) {
            r = root.right.val;
        }

        if (root.val == l + r && checkTree(root.left) && checkTree(root.right)) {
            return true;
        } else {
            return false;
        }
    }
}
