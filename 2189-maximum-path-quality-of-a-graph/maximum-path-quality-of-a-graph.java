class Solution {

    // Stores the maximum path quality found so far
    int maxValue = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {

        int n = values.length;

        // Step 1: Build adjacency list
        // map[u] -> {v : time required to travel u → v}
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        // Initialize graph nodes
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        // Fill graph (undirected)
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];

            map.get(u).put(v, t);
            map.get(v).put(u, t);
        }

        // Step 2: visited[i] → number of times node i is visited in current path
        // Important: we only add node value the first time we visit it
        int[] visited = new int[n];

        // Step 3: Start DFS from node 0
        dfs(0, 0, 0, values, map, visited, maxTime);

        return maxValue;
    }

    /**
     * DFS to explore all possible paths within time constraint
     *
     * @param node     current node
     * @param time     time spent so far
     * @param value    total collected value so far
     */
    private void dfs(int node, int time, int value,
                     int[] values,
                     HashMap<Integer, HashMap<Integer, Integer>> map,
                     int[] visited,
                     int maxTime) {

        // ❌ Prune path if time exceeds allowed limit
        if (time > maxTime) return;

        // ✅ Add node value only on first visit
        if (visited[node] == 0) {
            value += values[node];
        }

        // Mark visit (can revisit node but won't add value again)
        visited[node]++;

        // ✅ Valid path condition:
        // Only paths ending at node 0 are considered
        if (node == 0) {
            maxValue = Math.max(maxValue, value);
        }

        // Step 4: Explore all neighbors (backtracking)
        for (int next : map.get(node).keySet()) {

            int travelTime = map.get(node).get(next);

            // Move to next node
            dfs(next, time + travelTime, value, values, map, visited, maxTime);
        }

        // 🔙 Backtracking:
        // Remove current node from path before returning
        visited[node]--;
    }
}