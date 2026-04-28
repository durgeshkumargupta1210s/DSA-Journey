class Solution {
    public int minOperations(int[][] grid, int x) {

        // Step 1: Get dimensions of the grid
        int m = grid.length;
        int n = grid[0].length;

        // Step 2: Flatten 2D grid into 1D array for easier processing
        int[] arr = new int[m * n];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        // Step 3: Check feasibility
        // All elements must have same remainder when divided by x,
        // otherwise we can never make them equal using +/- x operations
        int rem = arr[0] % x;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % x != rem) {
                return -1; // Impossible case
            }
        }

        // Step 4: Sort the array
        // This helps in choosing the optimal target (median)
        Arrays.sort(arr);

        // Step 5: Choose median as target value
        // Reason: Median minimizes sum of absolute differences
        int median = arr[arr.length / 2];

        // Step 6: Calculate total operations required
        int ops = 0;

        for (int i = 0; i < arr.length; i++) {
            // Each operation changes value by x
            // So number of steps = difference / x
            ops += Math.abs(arr[i] - median) / x;
        }

        // Step 7: Return total operations
        return ops;
    }
}