class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // visited array to track already explored cells
        boolean[][] visited = new boolean[n][m];

        int max = 0; // stores maximum island area

        // Traverse entire grid
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                // If cell is land (1) and not visited → start BFS
                if(!visited[i][j] && grid[i][j] == 1){

                    // Compute area of this island
                    max = Math.max(max, bfs(i, j, visited, grid));
                }
            }
        }

        return max;
    }

    // BFS function to calculate area of island starting from (sr, sc)
    public static int bfs(int sr, int sc, boolean[][] visited, int[][] grid){

        // Queue for BFS traversal (stores coordinates)
        Queue<int[]> q = new LinkedList<>();

        // Add starting cell
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        int count = 1; // initial island size (starting cell)

        // 4-directional movement → down, up, right, left
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Standard BFS loop
        while(!q.isEmpty()){

            int[] current = q.poll(); // remove front cell

            // Explore all 4 neighbors
            for(int[] dir : directions){

                int r = current[0] + dir[0];
                int c = current[1] + dir[1];

                // Conditions:
                // 1. Inside grid bounds
                // 2. Not visited before
                // 3. Must be land (1), not water (0)
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length 
                   && !visited[r][c] && grid[r][c] == 1){

                    visited[r][c] = true;   // mark visited
                    q.add(new int[]{r, c}); // add to queue for further expansion
                    count++;                // increase island area
                }
            }
        }

        // Return total area of this connected component (island)
        return count;
    }
}