class Solution {

    // State representation
    class Pair {
        int node, time, cost;

        Pair(int node, int time, int cost) {
            this.node = node;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length;

        // ✅ MAP-BASED GRAPH
        // map[u] -> list of {neighbor, time}
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Build graph (undirected)
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];

            map.get(u).add(new int[]{v, t});
            map.get(v).add(new int[]{u, t});
        }

        // ✅ Min-heap (based on cost)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // ✅ dist[node][time] = minimum cost
        int[][] dist = new int[n][maxTime + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Initial state
        dist[0][0] = passingFees[0];
        pq.add(new Pair(0, 0, passingFees[0]));

        // Dijkstra with state expansion
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int time = curr.time;
            int cost = curr.cost;

            // ✅ Destination reached
            if (node == n - 1) return cost;

            // Explore neighbors
            for (int[] nei : map.get(node)) {

                int next = nei[0];
                int t = nei[1];

                int newTime = time + t;

                // Time constraint
                if (newTime > maxTime) continue;

                int newCost = cost + passingFees[next];

                // Relaxation
                if (dist[next][newTime] > newCost) {
                    dist[next][newTime] = newCost;
                    pq.add(new Pair(next, newTime, newCost));
                }
            }
        }

        return -1;
    }
}