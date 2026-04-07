class Solution {

    // State representation for BFS
    class Pair {
        int r; // row
        int c; // column
        int k; // remaining obstacle eliminations

        public Pair(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    public int shortestPath(int[][] grid, int k) {

        Queue<Pair> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        /*
         * 3D visited array:
         * visited[r][c][k] = have we visited cell (r,c)
         * with k eliminations remaining?
         *
         * WHY 3D?
         * Because reaching (r,c) with different k values
         * represents different states.
         */
        boolean[][][] visited = new boolean[m][n][k + 1];

        // Start from (0,0) with k eliminations
        q.add(new Pair(0, 0, k));
        visited[0][0][k] = true;

        int step = -1; // number of steps taken

        // 4-directional movement
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // Standard BFS traversal (level-wise)
        while (!q.isEmpty()) {

            int size = q.size();
            step++; // each level = one step

            // Process all nodes at current level
            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                int r = curr.r;
                int c = curr.c;
                int remaining = curr.k;

                // If destination reached → return steps
                if (r == m - 1 && c == n - 1) {
                    return step;
                }

                // Explore all 4 directions
                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Boundary check
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                        // CASE 1: Empty cell (no obstacle)
                        if (grid[nr][nc] == 0 && !visited[nr][nc][remaining]) {

                            visited[nr][nc][remaining] = true;
                            q.add(new Pair(nr, nc, remaining));
                        }

                        // CASE 2: Obstacle cell and we can eliminate it
                        else if (grid[nr][nc] == 1 && remaining > 0
                                 && !visited[nr][nc][remaining - 1]) {

                            // Use one elimination → k decreases
                            visited[nr][nc][remaining - 1] = true;
                            q.add(new Pair(nr, nc, remaining - 1));
                        }
                    }
                }
            }
        }

        // If destination not reachable
        return -1;
    }
}