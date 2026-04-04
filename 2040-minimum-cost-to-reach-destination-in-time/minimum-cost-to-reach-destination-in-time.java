class Solution {

    // Represents a state in our Dijkstra traversal
    // node → current vertex
    // time → total time spent to reach this node
    // cost → total cost incurred so far
    class Pair {
        int node, time, cost;

        Pair(int node, int time, int cost) {
            this.node = node;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length; // total number of nodes

        // ---------------------------------------------------
        // Step 1: Build Graph (Adjacency List using HashMap)
        // map[u] → list of {neighbor, time_to_reach}
        // ---------------------------------------------------
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        // Initialize empty adjacency list for each node
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Fill graph (undirected edges)
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];

            map.get(u).add(new int[]{v, t});
            map.get(v).add(new int[]{u, t});
        }

        // ---------------------------------------------------
        // Step 2: Min-Heap (Priority Queue)
        // We prioritize states with minimum cost
        // ---------------------------------------------------
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // ---------------------------------------------------
        // Step 3: Distance Table
        // dist[node][time] = minimum cost to reach 'node' at 'time'
        // This handles multi-dimensional state (node + time)
        // ---------------------------------------------------
        int[][] dist = new int[n][maxTime + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // ---------------------------------------------------
        // Step 4: Initialize starting state
        // Start from node 0 with:
        // time = 0
        // cost = passingFees[0]
        // ---------------------------------------------------
        dist[0][0] = passingFees[0];
        pq.add(new Pair(0, 0, passingFees[0]));

        // ---------------------------------------------------
        // Step 5: Modified Dijkstra Traversal
        // ---------------------------------------------------
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int time = curr.time;
            int cost = curr.cost;

            // ✅ If destination reached, return minimum cost
            // Since PQ is sorted by cost, this is optimal
            if (node == n - 1) return cost;

            // Explore all neighbors of current node
            for (int[] nei : map.get(node)) {

                int next = nei[0]; // neighbor node
                int t = nei[1];    // time to reach neighbor

                int newTime = time + t;

                // ❌ Skip if exceeds maximum allowed time
                if (newTime > maxTime) continue;

                int newCost = cost + passingFees[next];

                // ✅ Relaxation:
                // Only update if we found a cheaper way to reach
                // 'next' node at 'newTime'
                if (dist[next][newTime] > newCost) {
                    dist[next][newTime] = newCost;

                    // Push new state into PQ
                    pq.add(new Pair(next, newTime, newCost));
                }
            }
        }

        // ❌ If destination cannot be reached within maxTime
        return -1;
    }
}