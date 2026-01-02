class Solution {

    // Pair class to store (node, current cost to reach this node)
    static class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    // Adjacency list:
    // node -> (neighbor -> edge cost)
    HashMap<Integer, Map<Integer, Integer>> map;

    public int networkDelayTime(int[][] times, int n, int k) {

        // Initialize adjacency list for all nodes (1 to n)
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }

        // Build the directed graph
        // times[i] = {u, v, cost}
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int cost = time[2];

            map.get(u).put(v, cost);
        }

        // dist[i] will store the shortest time to reach node i from source k
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance to source node is 0
        dist[k] = 0;

        // Min-heap based on cost (Dijkstra's priority queue)
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // Start from the source node
        pq.add(new Pair(k, 0));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {

            // Extract node with minimum current cost
            Pair current = pq.poll();

            // If we have already found a better path, skip this one
            if (current.cost > dist[current.node]) {
                continue;
            }

            // Relax all outgoing edges from current.node
            for (int nbrs : map.get(current.node).keySet()) {

                // Cost of edge current.node -> nbrs
                int edgeCost = map.get(current.node).get(nbrs);

                // New possible cost to reach neighbor
                int newCost = current.cost + edgeCost;

                // If shorter path is found, update and push to PQ
                if (newCost < dist[nbrs]) {
                    dist[nbrs] = newCost;
                    pq.add(new Pair(nbrs, newCost));
                }
            }
        }

        // Find the maximum time among all shortest paths
        int ans = 0;
        for (int i = 1; i <= n; i++) {

            // If any node is unreachable, return -1
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        // The maximum shortest time is the network delay time
        return ans;
    }
}
