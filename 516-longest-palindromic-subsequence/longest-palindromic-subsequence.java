class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][]dp=new int[s.length()][s.length()];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return lpsHelper(s, 0, s.length() - 1, dp);
    }
    int ans =0;

    // Recursive function to find LPS length between indices i and j
    private int lpsHelper(String s, int i, int j, int[][]dp) {
        // Base cases
        if (i > j) return 0;     // invalid range

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if (i == j) return 1;    // single char- palindrome length 1

        // If first and last chars match
        if (s.charAt(i) == s.charAt(j)) {
            ans= 2 + lpsHelper(s, i + 1, j - 1, dp);
        } else {
            // If they don't match, try skipping one char from either end
            ans= Math.max(lpsHelper(s, i + 1, j, dp), lpsHelper(s, i, j - 1, dp));
           
        }
         return dp[i][j]=ans;
    }
}
