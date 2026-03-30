class Solution {

    public int findMaxFish(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int max = 0; // stores maximum fish collected

        // visited array to track processed cells
        boolean[][] visited = new boolean[n][m];

        // Traverse entire grid
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                // Start BFS only if:
                // 1. Not visited
                // 2. Cell has fish (>0)
                if(!visited[i][j] && grid[i][j] > 0){

                    // Compute total fish in this connected component
                    max = Math.max(max, bfs(i, j, visited, grid));
                }
            }
        }

        return max;
    }

    // BFS to calculate total fish in connected water region
    public static int bfs(int sr, int sc, boolean[][] visited, int[][] grid){

        Queue<int[]> q = new LinkedList<>();

        // Add starting cell
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true; // IMPORTANT: mark visited

        int count = grid[sr][sc]; // initialize with starting fish

        // 4-directional movement
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int[] current = q.poll();

            // Explore neighbors
            for(int[] dir : directions){

                int r = current[0] + dir[0];
                int c = current[1] + dir[1];

                // Conditions:
                // 1. Within bounds
                // 2. Not visited
                // 3. Has fish (>0)
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length
                   && !visited[r][c] && grid[r][c] > 0){

                    visited[r][c] = true;      // mark visited
                    q.add(new int[]{r, c});   // push to queue
                    count += grid[r][c];      // add fish
                }
            }
        }

        return count; // total fish in this region
    }
}