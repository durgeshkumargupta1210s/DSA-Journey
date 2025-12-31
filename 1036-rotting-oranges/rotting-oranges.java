class Solution {

    // Function to calculate the minimum time required to rot all oranges
    public int orangesRotting(int[][] grid) {

        // Number of rows and columns
        int m = grid.length;
        int n = grid[0].length;

        // Count of fresh oranges
        int freshcount = 0;

        // Queue for BFS to store positions of rotten oranges
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Traverse the grid
        // - Add all initially rotten oranges to the queue
        // - Count total fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Rotten orange found → add to BFS queue
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                // Fresh orange found → increase count
                else if (grid[i][j] == 1) {
                    freshcount++;
                }
            }
        }

        // If there are no fresh oranges initially, no time is needed
        if (freshcount == 0) {
            return 0;
        }

        // Directions array for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Variable to track time (minutes)
        int min = 0;

        // Step 2: Perform multi-source BFS
        while (!q.isEmpty()) {

            // Number of rotten oranges at the current minute
            int size = q.size();

            // Flag to check if any fresh orange rots in this minute
            boolean rotten = false;

            // Process all rotten oranges of the current level
            for (int i = 0; i < size; i++) {

                // Current rotten orange position
                int[] current = q.poll();

                // Explore all 4 adjacent directions
                for (int[] dir : directions) {

                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];

                    // Check boundaries and if the adjacent orange is fresh
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {

                        // Make the fresh orange rotten
                        grid[r][c] = 2;

                        // Add newly rotten orange to the queue
                        q.offer(new int[]{r, c});

                        // Mark that rotting happened in this minute
                        rotten = true;

                        // Decrease fresh orange count
                        freshcount--;
                    }
                }
            }

            // Increment time only if at least one orange rotted
            if (rotten) {
                min++;
            }
        }

        // If all fresh oranges are rotten, return time
        // Otherwise, return -1 (some oranges could not rot)
        return freshcount == 0 ? min : -1;
    }
}
