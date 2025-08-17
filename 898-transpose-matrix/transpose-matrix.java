class Solution {
    public int[][] transpose(int[][] matrix) {
       return transposeMatrix(matrix); 
    }
    private static int[][] transposeMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] ans = new int[n][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}