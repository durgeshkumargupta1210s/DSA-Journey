class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        // Graph representation:
        // graph[u] -> (v -> weight)
        // Using nested map for weighted adjacency
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        // Initialize graph with empty neighbor maps for each node
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }

        // Build the graph
        // Each edge has 'cnt' subdivided nodes → actual weight = cnt + 1
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];

            // Undirected graph → add both directions
            graph.get(u).put(v, cnt + 1);
            graph.get(v).put(u, cnt + 1);
        }

        // Min-Heap (PriorityQueue) for Dijkstra
        // Stores {node, distance from source}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Distance array: shortest distance from node 0
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Start from node 0
        dist[0] = 0;
        pq.add(new int[]{0, 0});

        // Standard Dijkstra Algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            // Skip if we already found a better path
            if (d > dist[node]) continue;

            // Traverse all neighbors of current node
            for (Map.Entry<Integer, Integer> entry : graph.get(node).entrySet()) {
                int next = entry.getKey();   // neighbor node
                int weight = entry.getValue(); // edge weight

                // Relaxation step
                if (d + weight < dist[next]) {
                    dist[next] = d + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        int result = 0;

        // Step 1: Count all original nodes reachable within maxMoves
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                result++;
            }
        }

        // Step 2: Count reachable subdivided nodes on each edge
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];

            // Moves remaining after reaching u and v
            int fromU = dist[u] > maxMoves ? 0 : maxMoves - dist[u];
            int fromV = dist[v] > maxMoves ? 0 : maxMoves - dist[v];

            // Total reachable subdivided nodes on this edge
            // We cannot exceed cnt (total subdivisions)
            result += Math.min(cnt, fromU + fromV);
        }

        return result;
    }
}