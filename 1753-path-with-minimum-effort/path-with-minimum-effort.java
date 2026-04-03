class Solution {

    // Pair class to store current cell (r, c) and effort required to reach here
    class Pair {
        int r;
        int c;
        int effort;

        public Pair(int r, int c, int effort) {
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;      // number of rows
        int n = heights[0].length;   // number of columns

        // Min-heap based on effort (Dijkstra-like approach)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);

        // dist[r][c] → minimum effort required to reach cell (r, c)
        int[][] dist = new int[m][n];

        // Initialize all distances with infinity
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Start from (0,0) with 0 effort
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;

        // 4 possible directions (right, left, down, up)
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int r = current.r;
            int c = current.c;
            int effort = current.effort;

            // If we reached destination, return the minimum effort
            if (r == m - 1 && c == n - 1) return effort;

            // Explore all 4 directions
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundaries
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    // Effort to move to next cell = absolute height difference
                    int cost = Math.abs(heights[r][c] - heights[nr][nc]);

                    // Path effort = max of current path effort and this step cost
                    int newEffort = Math.max(cost, effort);

                    // Relaxation step (Dijkstra)
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        // In case destination is unreachable (not possible here)
        return 0;
    }
}