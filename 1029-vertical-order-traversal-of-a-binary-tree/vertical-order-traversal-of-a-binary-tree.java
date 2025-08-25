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
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, 0, 0);

        // column-wise traversal
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, List<Integer>> levelMap = entry.getValue();
            List<Integer> list = new ArrayList<>();

            // level-wise traversal
            for (Map.Entry<Integer, List<Integer>> subEntry : levelMap.entrySet()) {
                List<Integer> sublist = subEntry.getValue();
                Collections.sort(sublist); // sort values in same row, col
                list.addAll(sublist);
            }

            result.add(list);
        }
        return result;
    }

    public void dfs(TreeNode root, int col, int level) {
        if (root == null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(level, new ArrayList<>());
        map.get(col).get(level).add(root.val);

        dfs(root.left, col - 1, level + 1);
        dfs(root.right, col + 1, level + 1);
    }
}
