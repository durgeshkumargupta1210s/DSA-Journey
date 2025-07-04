class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;  // Binary search on columns

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = getMaxRowInCol(mat, m, mid);  // Find max in current column

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < n ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            } else if (left > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static int getMaxRowInCol(int[][] mat, int m, int col) {
        int maxVal = -1;
        int maxRow = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxRow = i;
            }
        }
        return maxRow;
    }
}
