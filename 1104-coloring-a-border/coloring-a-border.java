class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int original = grid[row][col];

        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            boolean isBorder = false;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    isBorder = true;
                } 
                else if (grid[nr][nc] != original) {
                    isBorder = true;
                } 
                else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }

            if (isBorder) {
                borders.add(new int[]{r, c});
            }
        }

        // Color only border cells
        for (int[] cell : borders) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }
}