import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Map to store diagonals. Key = i+j (diagonal level), Value = list of elements in that diagonal
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Traverse the matrix and fill the map
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        // Prepare the result array
        int[] result = new int[m * n];
        int index = 0;

        // Traverse the map by sorted keys (0 to m+n-2)
        for (int k = 0; k <= m + n - 2; k++) {
            List<Integer> diagonal = map.get(k);

            // Reverse the list if the diagonal level is even
            if (k % 2 == 0) {
                Collections.reverse(diagonal);
            }

            for (int val : diagonal) {
                result[index++] = val;
            }
        }

        return result;
    }
}
