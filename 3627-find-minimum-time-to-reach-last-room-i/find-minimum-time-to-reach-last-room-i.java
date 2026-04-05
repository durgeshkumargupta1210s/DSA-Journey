class Solution {

    // Pair class to store current cell and time taken to reach it
    class Pair {
        int r, c, time;

        Pair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public int minTimeToReach(int[][] moveTime) {

        int m = moveTime.length;
        int n = moveTime[0].length;

        // Step 1: Distance matrix
        // dist[r][c] → minimum time required to reach cell (r, c)
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Step 2: Min-Heap (Dijkstra)
        // Always process the cell with minimum time first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        // Starting point (0,0) at time 0
        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        // Directions: right, left, down, up
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        // Step 3: Dijkstra traversal
        while (!pq.isEmpty()) {

            Pair cur = pq.poll();
            int r = cur.r, c = cur.c, time = cur.time;

            // ✅ If destination reached → return minimum time
            if (r == m - 1 && c == n - 1) return time;

            // ❌ Skip outdated entries (important optimization)
            if (time > dist[r][c]) continue;

            // Step 4: Explore all 4 directions
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Check grid boundaries
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    /**
                     * Core Logic:
                     * We cannot enter (nr, nc) before moveTime[nr][nc]
                     * So:
                     * - If we arrive early → we wait
                     * - Then we take 1 step to move
                     *
                     * newTime = max(currentTime, moveTime[nr][nc]) + 1
                     */
                    int newTime = Math.max(moveTime[nr][nc], time) + 1;

                    // Relaxation step (Dijkstra)
                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        pq.add(new Pair(nr, nc, newTime));
                    }
                }
            }
        }

        // If destination is unreachable
        return -1;
    }
}