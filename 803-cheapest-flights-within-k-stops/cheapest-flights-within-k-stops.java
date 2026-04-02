class Solution {

    // Custom Pair class to store:
    // vrtx -> current node
    // cost -> total cost to reach this node
    // k -> number of stops taken so far
    class Pair {
        int vrtx;
        int cost;
        int k;

        public Pair(int vrtx, int cost, int k) {
            this.vrtx = vrtx;
            this.cost = cost;
            this.k = k;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Step 1: Build adjacency list
        // map[u] -> (v, cost)
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        // Fill graph with flight data
        for (int[] arr : flights) {
            int u = arr[0]; // source
            int v = arr[1]; // destination
            int c = arr[2]; // cost

            map.get(u).put(v, c);
        }

        // Step 2: Distance array
        // dist[i] = minimum cost to reach node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Step 3: BFS Queue (Modified BFS)
        // We use queue instead of PQ because we are controlling stops manually
        Queue<Pair> q = new LinkedList<>();

        // Start from source node
        q.add(new Pair(src, 0, 0));

        // Step 4: BFS Traversal
        while (!q.isEmpty()) {
            Pair current = q.poll();

            // If stops exceed k, skip this path
            if (current.k > k) {
                continue;
            }

            // Traverse all neighbors
            for (int nbrs : map.get(current.vrtx).keySet()) {

                int newCost = current.cost + map.get(current.vrtx).get(nbrs);

                // Relaxation step:
                // Only update if we found a cheaper path
                if (newCost < dist[nbrs]) {

                    dist[nbrs] = newCost;

                    // Add neighbor to queue with incremented stops
                    q.add(new Pair(nbrs, newCost, current.k + 1));
                }
            }
        }

        // Step 5: Return result
        // If destination is unreachable, return -1
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}