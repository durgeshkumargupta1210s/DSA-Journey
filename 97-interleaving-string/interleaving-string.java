class Solution {
    static int [][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp=new int[s1.length()+1][s2.length()+1];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }

        return solve(s1, s2, s3, 0, 0);
    }

    public static boolean solve(String s1, String s2, String s3, int i, int j) {

        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }

        int k = i + j;

        boolean first = false;
        boolean second = false;

        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            first = solve(s1, s2, s3, i + 1, j);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            second = solve(s1, s2, s3, i, j + 1);
        }

        boolean result=first || second;
        dp[i][j]=result ?1 :0;

        return result;
    }
}