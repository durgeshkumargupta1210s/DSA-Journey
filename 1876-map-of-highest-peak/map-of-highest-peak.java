import java.util.*;

class Solution {

    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 1: Initialization
        // Water cells → height 0 (sources)
        // Land cells → -1 (unvisited)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }

        // Step 2: Multi-source BFS
        while (!q.isEmpty()) {

            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // boundary + unvisited check
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && height[nr][nc] == -1) {

                    height[nr][nc] = height[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return height;
    }
}
