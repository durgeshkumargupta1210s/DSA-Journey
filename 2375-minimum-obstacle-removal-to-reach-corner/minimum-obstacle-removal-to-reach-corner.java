class Solution {

    // Represents a cell in grid with current cost (obstacles removed so far)
    class Pair {
        int r;     // row
        int c;     // column
        int cost;  // number of obstacles removed to reach here

        public Pair(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public int minimumObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Min-heap based on minimum cost (Dijkstra)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        /*
         * dist[r][c] = minimum obstacles removed to reach (r,c)
         */
        int[][] dist = new int[m][n];

        // Initialize distances with infinity
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Starting point
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        // 4-direction movement
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int r = curr.r;
            int c = curr.c;
            int cost = curr.cost;

            // If destination reached → return minimum cost
            if (r == m - 1 && c == n - 1) {
                return cost;
            }

            /*
             * Dijkstra pruning:
             * If we already found a better path to this cell, skip
             */
            if (cost > dist[r][c]) continue;

            // Explore neighbors
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Boundary check
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    /*
                     * COST LOGIC:
                     * If next cell is:
                     * 0 → no obstacle → cost stays same
                     * 1 → obstacle → cost + 1
                     */
                    int newCost;

                    if (grid[nr][nc] == 0) {
                        newCost = cost;       // no extra cost
                    } else {
                        newCost = cost + 1;   // remove obstacle
                    }

                    // Relaxation step
                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new Pair(nr, nc, newCost));
                    }
                }
            }
        }

        // If destination is unreachable
        return -1;
    }
}