class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        int[][] maxHealthAt = new int[m][n];
        for (int[] row : maxHealthAt) {
            Arrays.fill(row, -1);
        }

        // 🔴 FIX: Deduct health for starting cell if unsafe
        int startHealth = health - (grid.get(0).get(0) == 1 ? 1 : 0);

        // If health becomes zero or negative immediately, no valid path
        if (startHealth <= 0) return false;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, startHealth});
        maxHealthAt[0][0] = startHealth;

        while (!q.isEmpty()) {

            int[] state = q.poll();
            int r = state[0];
            int c = state[1];
            int h = state[2];

            if (r == m - 1 && c == n - 1 && h > 0) {
                return true;
            }

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int nh = h - (grid.get(nr).get(nc) == 1 ? 1 : 0);

                if (nh > 0 && nh > maxHealthAt[nr][nc]) {
                    maxHealthAt[nr][nc] = nh;
                    q.offer(new int[]{nr, nc, nh});
                }
            }
        }

        return false;
    }
}
