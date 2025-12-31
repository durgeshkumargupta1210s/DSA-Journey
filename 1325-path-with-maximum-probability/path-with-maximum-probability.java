class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start_node, int end_node) {

        // Step 1: Build adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        // Step 2: Max probability array
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        // Step 3: Max Heap (higher probability first)
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        pq.offer(new Pair(start_node, 1.0));

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;

            // Early stop
            if (node == end_node) {
                return prob;
            }

            // Ignore outdated entries
            if (prob < maxProb[node]) continue;

            for (Pair next : graph.get(node)) {
                double newProb = prob * next.prob;

                if (newProb > maxProb[next.node]) {
                    maxProb[next.node] = newProb;
                    pq.offer(new Pair(next.node, newProb));
                }
            }
        }

        return 0.0;
    }

    // Helper class
    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
