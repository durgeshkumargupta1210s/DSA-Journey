class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: DFS
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int src, int dest, boolean[] visited) {

        // Base case
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        // Visit neighbors
        for (int nbr : graph.get(src)) {
            if (!visited[nbr]) {
                if (dfs(graph, nbr, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
