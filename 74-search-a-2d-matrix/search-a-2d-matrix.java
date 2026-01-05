class Solution {

    // Searches for target in a 2D matrix using binary search
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int m = matrix.length;

        // Number of columns
        int n = matrix[0].length;

        // Treat the 2D matrix as a 1D sorted array
        // low points to the first index
        int low = 0;

        // high points to the last index of the virtual 1D array
        int high = (m * n) - 1;

        // Standard binary search loop
        while (low <= high) {

            // Calculate mid index
            int mid = (low + high) / 2;

            // Convert 1D index to 2D coordinates
            // Row is obtained by division
            int row = mid / n;

            // Column is obtained by modulo
            int col = mid % n;

            // If target is found, return true
            if (matrix[row][col] == target) {
                return true;
            }

            // If current element is greater than target,
            // search in the left half
            else if (matrix[row][col] > target) {
                high = mid - 1;
            }

            // If current element is smaller than target,
            // search in the right half
            else {
                low = mid + 1;
            }
        }

        // Target not found in the matrix
        return false;
    }
}
