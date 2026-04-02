class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        // This will store all possible paths from source (0) to target (n-1)
        List<List<Integer>> result = new ArrayList<>();

        // Temporary list to store the current path during DFS traversal
        List<Integer> path = new ArrayList<>();

        // Start path with source node (0)
        path.add(0);

        // Start DFS from node 0
        dfs(graph, 0, result, path);

        return result;
    }

    public static void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {

        // Base Case:
        // If we reached the target node (n-1), store the current path
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path)); // deep copy of path
            return;
        }

        // Explore all neighbors of current node
        for (int nbrs : graph[node]) {

            // Choose: add neighbor to current path
            path.add(nbrs);

            // Explore: recursive DFS call
            dfs(graph, nbrs, result, path);

            // Backtrack: remove last added node to try other paths
            path.remove(path.size() - 1);
        }
    }
}