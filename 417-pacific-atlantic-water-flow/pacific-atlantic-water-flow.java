class Solution {

    // Main function to find all cells from where water can flow to both oceans
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length, m = heights[0].length;

        // visited arrays to track cells reachable from each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // queues for multi-source BFS (starting from ocean borders)
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        // ---------------- PACIFIC OCEAN ----------------
        // Pacific touches TOP row and LEFT column

        // Add all top row cells
        for(int j = 0; j < m; j++){
            pacQ.add(new int[]{0, j});
            pacific[0][j] = true;
        }

        // Add all left column cells
        for(int i = 0; i < n; i++){
            pacQ.add(new int[]{i, 0});
            pacific[i][0] = true;
        }

        // ---------------- ATLANTIC OCEAN ----------------
        // Atlantic touches BOTTOM row and RIGHT column

        // Add all bottom row cells
        for(int j = 0; j < m; j++){
            atlQ.add(new int[]{n-1, j});
            atlantic[n-1][j] = true;
        }

        // Add all right column cells
        for(int i = 0; i < n; i++){
            atlQ.add(new int[]{i, m-1});
            atlantic[i][m-1] = true;
        }

        // Run BFS for both oceans
        bfs(pacQ, pacific, heights);
        bfs(atlQ, atlantic, heights);

        // Collect cells reachable from BOTH oceans
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    // BFS function to mark all reachable cells from given ocean
    void bfs(Queue<int[]> q, boolean[][] vis, int[][] heights){

        int n = heights.length, m = heights[0].length;

        // 4-directional movement (down, up, right, left)
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            // Explore all 4 directions
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                // Valid cell + not visited + reverse water flow condition
                // NOTE: We are doing reverse BFS:
                // Water flows from high → low,
                // so we move from ocean towards higher or equal height
                if(nr >= 0 && nc >= 0 && nr < n && nc < m &&
                   !vis[nr][nc] &&
                   heights[nr][nc] >= heights[r][c]) {

                    vis[nr][nc] = true;          // mark as reachable
                    q.add(new int[]{nr, nc});    // push to queue
                }
            }
        }
    }
}