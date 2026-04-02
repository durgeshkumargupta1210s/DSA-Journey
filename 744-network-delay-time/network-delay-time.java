class Solution {

    // Pair class to store (vertex, cost so far)
    class Pair {
        int vrtx;
        int cost;

        public Pair(int vrtx, int cost) {
            this.vrtx = vrtx;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build adjacency list
        // map[u] -> {v : cost}
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        // Initialize graph for all nodes (1 to n)
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }

        // Fill graph with directed edges
        for (int[] arr : times) {
            int u = arr[0];
            int v = arr[1];
            int c = arr[2];

            map.get(u).put(v, c);
        }

        // Step 2: Dijkstra's Algorithm setup

        // Track visited nodes (final shortest distance found)
        HashSet<Integer> visited = new HashSet<>();

        // Min-heap based on cost (smallest cost first)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // Store shortest distances of nodes in order of processing
        ArrayList<Integer> list = new ArrayList<>();

        // Start from source node k with cost 0
        pq.add(new Pair(k, 0));

        // Step 3: Process nodes using priority queue
        while (!pq.isEmpty()) {

            Pair node = pq.poll();

            // Skip if already processed (important for Dijkstra)
            if (visited.contains(node.vrtx)) {
                continue;
            }

            // Mark node as visited
            visited.add(node.vrtx);

            // Store the shortest distance for this node
            list.add(node.cost);

            // Explore neighbors
            for (int nbrs : map.get(node.vrtx).keySet()) {

                // Only process unvisited neighbors
                if (!visited.contains(nbrs)) {

                    // Add neighbor with updated cost
                    pq.add(new Pair(
                        nbrs,
                        node.cost + map.get(node.vrtx).get(nbrs)
                    ));
                }
            }
        }

        // Step 4: If all nodes are reached → return max distance
        // Else → some nodes unreachable → return -1
        return list.size() == n ? max(list) : -1;
    }

    // Utility function to get maximum value from list
    public static int max(List<Integer> list) {
        int g = 0;
        for (int ele : list) {
            g = Math.max(g, ele);
        }
        return g;
    }
}