class Solution {

    // Custom class to represent a state in the grid
    class Pair {
        int r;     // current row
        int c;     // current column
        int k;     // remaining obstacle eliminations
        int step;  // steps taken to reach this cell

        public Pair(int r, int c, int k, int step) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.step = step;
        }
    }

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        // Min-heap (Dijkstra style) based on minimum steps
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.step - b.step);

        // Start from (0,0) with k eliminations and 0 steps
        pq.add(new Pair(0, 0, k, 0));

        /*
         * 3D distance array:
         * dist[r][c][k] = minimum steps required to reach cell (r,c)
         * with k eliminations remaining
         *
         * WHY 3D?
         * Because reaching same cell with different k values is different state.
         * Example:
         * (r,c, k=2) is better than (r,c, k=0)
         */
        int[][][] dist = new int[m][n][k + 1];

        // Initialize all distances with infinity
        for (int[][] layer : dist) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        // Starting point
        dist[0][0][k] = 0;

        // 4 possible movement directions
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int r = current.r;
            int c = current.c;
            int kc = current.k;     // remaining eliminations
            int step = current.step;

            // If we reached destination → return steps
            if (r == m - 1 && c == n - 1) {
                return step;
            }

            /*
             * Important pruning:
             * If we already found a better way to reach this state,
             * skip this one (classic Dijkstra optimization)
             */
            if (step > dist[r][c][kc]) continue;

            // Explore all 4 directions
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                int newStep = step + 1;

                // Boundary check
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    // CASE 1: Empty cell (no obstacle)
                    if (grid[nr][nc] == 0) {

                        /*
                         * Same k (no elimination used)
                         * Relaxation condition
                         */
                        if (newStep < dist[nr][nc][kc]) {
                            dist[nr][nc][kc] = newStep;
                            pq.add(new Pair(nr, nc, kc, newStep));
                        }
                    }

                    // CASE 2: Obstacle cell and we can eliminate it
                    else if (grid[nr][nc] == 1 && kc > 0) {

                        /*
                         * We use one elimination → k decreases by 1
                         */
                        if (newStep < dist[nr][nc][kc - 1]) {
                            dist[nr][nc][kc - 1] = newStep;
                            pq.add(new Pair(nr, nc, kc - 1, newStep));
                        }
                    }
                }
            }
        }

        // If destination is not reachable
        return -1;
    }
}