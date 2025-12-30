import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        // Build adjacency lists
        List<int[]>[] forward = new ArrayList[n]; // normal edges
        List<int[]>[] reverse = new ArrayList[n]; // reversed edges (for switching)

        for (int i = 0; i < n; i++) {
            forward[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            forward[u].add(new int[]{v, w});   // direct move
            reverse[v].add(new int[]{u, w});   // possible reversal
        }

        // Dijkstra’s shortest path setup
        long[] best = new long[n];
        Arrays.fill(best, Long.MAX_VALUE);
        best[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // {current cost, node}

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long currentCost = top[0];
            int node = (int) top[1];

            if (node == n - 1) {
                return (int) currentCost; // reached destination
            }

            if (currentCost > best[node]) continue;

            // Option 1: follow normal outgoing edges
            for (int[] next : forward[node]) {
                int neighbor = next[0], weight = next[1];
                long newCost = currentCost + weight;
                if (newCost < best[neighbor]) {
                    best[neighbor] = newCost;
                    pq.offer(new long[]{newCost, neighbor});
                }
            }

            // Option 2: use a "switch" to reverse incoming edges
            for (int[] prev : reverse[node]) {
                int neighbor = prev[0], weight = prev[1];
                long newCost = currentCost + 2L * weight;
                if (newCost < best[neighbor]) {
                    best[neighbor] = newCost;
                    pq.offer(new long[]{newCost, neighbor});
                }
            }
        }

        return -1; // destination unreachable
    }
}
