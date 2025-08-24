class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return new ArrayList<>(result); // convert to List<List<Integer>>
    }

    private void dfs(TreeNode node, int level, List<LinkedList<Integer>> result) {
        if (node == null) return;

        // Create a new list if visiting this level first time
        if (level >= result.size()) {
            result.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            // even level → left to right
            result.get(level).addLast(node.val);
        } else {
            // odd level → right to left
            result.get(level).addFirst(node.val);
        }

        // Recurse deeper
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}
