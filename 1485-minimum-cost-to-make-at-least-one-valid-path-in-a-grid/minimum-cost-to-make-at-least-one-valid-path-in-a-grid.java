class Solution {

    // Helper class to store cell position and cost to reach it
    class Pair {
        int r;     // row
        int c;     // column
        int cost;  // cost to reach this cell

        public Pair(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid) {

        // Min-heap (PriorityQueue) to always process the cell with minimum cost first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int m = grid.length;
        int n = grid[0].length;

        // Distance array to store minimum cost to reach each cell
        int[][] dist = new int[m][n];

        // Initialize all distances as infinity (unvisited)
        for (int[] a : dist) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        // Starting point (0,0) has cost 0
        dist[0][0] = 0;

        // Add starting cell to priority queue
        pq.add(new Pair(0, 0, 0));

        // Directions: right, left, down, up
        int[][] dir = {
            {0, 1},   // right
            {0, -1},  // left
            {1, 0},   // down
            {-1, 0}   // up
        };

        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int cost = curr.cost;

            // If we already found a better path, skip this one
            if (cost > dist[r][c]) continue;

            // If we reached destination, return the minimum cost
            if (r == m - 1 && c == n - 1) {
                return cost;
            }

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {

                int nr = r + dir[i][0]; // new row
                int nc = c + dir[i][1]; // new column

                // Check boundaries
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    /*
                     * If current cell direction matches i+1:
                     *   → no cost (0)
                     * Else:
                     *   → change direction → cost = 1
                     */
                    int extraCost = (grid[r][c] == i + 1) ? 0 : 1;

                    int newCost = cost + extraCost;

                    // Relaxation step (Dijkstra)
                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new Pair(nr, nc, newCost));
                    }
                }
            }
        }

        // If destination is unreachable (not possible here logically)
        return 0;
    }
}