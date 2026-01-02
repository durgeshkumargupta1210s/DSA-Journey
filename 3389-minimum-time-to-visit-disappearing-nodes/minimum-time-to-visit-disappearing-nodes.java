import java.util.*;

class Solution {

    static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        // Step 1: Build adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        // Step 2: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Step 3: Min-heap (time, node)
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(0, 0));

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int node = curr.node;
            int time = curr.time;

            // Ignore outdated state
            if (time > dist[node]) continue;

            for (Pair next : graph.get(node)) {
                int newTime = time + next.time;

                // Key condition: must arrive BEFORE disappearance
                if (newTime < disappear[next.node]
                        && newTime < dist[next.node]) {

                    dist[next.node] = newTime;
                    pq.offer(new Pair(next.node, newTime));
                }
            }
        }

        // Step 5: Convert unreachable to -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
