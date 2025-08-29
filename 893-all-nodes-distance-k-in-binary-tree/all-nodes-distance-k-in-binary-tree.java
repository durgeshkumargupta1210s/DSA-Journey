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

import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Build parent map
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, null, parent);

        // Step 2: DFS from target
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(target, 0, k, parent, visited, result);

        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        if (par != null) parent.put(node, par);
        buildParentMap(node.left, node, parent);
        buildParentMap(node.right, node, parent);
    }

    private void dfs(TreeNode node, int dist, int k,
                     Map<TreeNode, TreeNode> parent,
                     Set<TreeNode> visited,
                     List<Integer> result) {
        if (node == null || visited.contains(node)) return;

        visited.add(node);

        if (dist == k) {
            result.add(node.val);
            return;
        }

        dfs(node.left, dist + 1, k, parent, visited, result);
        dfs(node.right, dist + 1, k, parent, visited, result);
        dfs(parent.get(node), dist + 1, k, parent, visited, result);
    }
}
