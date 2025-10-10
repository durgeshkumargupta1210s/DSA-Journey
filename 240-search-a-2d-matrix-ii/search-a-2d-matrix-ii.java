class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean ans = false;

        for (int i = 0; i < m; i++) {
            // Check if target could be in this row
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                ans = searchElement(matrix[i], target);
            }
            if (ans) {
                return true;
            }
        }
        return false;
    }

    public boolean searchElement(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
