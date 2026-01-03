class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            int wins = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    wins++;
                }
            }

            if (wins == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
