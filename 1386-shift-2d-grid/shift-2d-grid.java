import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;         // total number of elements
        k = k % total;            // no need to shift more than total size

        // Create new grid to hold shifted values
        int[][] newGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oldIndex = i * n + j;
                int newIndex = (oldIndex + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                newGrid[newRow][newCol] = grid[i][j];
            }
        }

        // Convert newGrid to List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(newGrid[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
