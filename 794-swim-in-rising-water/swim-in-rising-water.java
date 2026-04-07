class Solution {

    // Represents a cell with current time required to reach it
    class Pair {
        int r;     // row
        int c;     // column
        int time;  // maximum elevation encountered so far

        public Pair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Min-heap based on minimum time (Dijkstra)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        /*
         * dist[r][c] = minimum time required to reach (r,c)
         * Time here means the maximum elevation encountered along the path
         */
        int[][] dist = new int[m][n];

        // Initialize distances with infinity
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Starting point:
        // Time = grid[0][0] because water must rise to this level first
        dist[0][0] = grid[0][0];

        pq.add(new Pair(0, 0, grid[0][0]));

        // 4-direction movement
        int[][] directions = {{0,-1}, {0,1}, {1,0}, {-1,0}};

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int r = curr.r;
            int c = curr.c;
            int time = curr.time;

            // If destination reached → return minimum required time
            if (r == m - 1 && c == n - 1) {
                return time;
            }

            // Dijkstra pruning
            if (time > dist[r][c]) continue;

            // Explore neighbors
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    /*
                     * KEY TRANSITION:
                     * We must wait until water level reaches grid[nr][nc]
                     *
                     * So actual time = max(current time, next cell height)
                     */
                    int newTime = Math.max(time, grid[nr][nc]);

                    // Relaxation step
                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        pq.add(new Pair(nr, nc, newTime));
                    }
                }
            }
        }

        return -1;
    }
}