class Solution {

    // Pair class to store (vertex, probability so far)
    class Pair {
        int vrtx;
        double prob;

        public Pair(int vrtx, double prob) {
            this.vrtx = vrtx;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        // Step 1: Build graph using adjacency map
        // map[u] -> {v : probability}
        HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();

        // Initialize empty adjacency list for each node
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        // Populate graph (undirected)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];

            map.get(u).put(v, cost);
            map.get(v).put(u, cost);
        }

        // Step 2: Max Heap (Priority Queue)
        // We want to process node with MAX probability first
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        // Step 3: Distance array to store max probability to reach each node
        double[] dist = new double[n];

        // Start node has probability = 1
        dist[start_node] = 1.0;

        // Push start node into PQ
        pq.add(new Pair(start_node, 1.0));

        // Step 4: Modified Dijkstra's Algorithm
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int node = curr.vrtx;
            double prob = curr.prob;

            // Early exit: first time reaching end_node gives max probability
            if (node == end_node) {
                return prob;
            }

            // Skip if we already have a better probability recorded
            if (prob < dist[node]) {
                continue;
            }

            // Explore neighbors
            for (int nbrs : map.get(node).keySet()) {

                // New probability = current * edge probability
                double newprob = prob * map.get(node).get(nbrs);

                // Relaxation step (maximize probability)
                if (newprob > dist[nbrs]) {
                    dist[nbrs] = newprob;

                    // Push updated state into PQ
                    pq.add(new Pair(nbrs, newprob));
                }
            }
        }

        // If end node is not reachable
        return 0;
    }
}