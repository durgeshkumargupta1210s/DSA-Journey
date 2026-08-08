class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m+1][n+1];
        for(int [] a : dp){
           Arrays.fill(a,-1);
        }
        
        return solve(0,0,m,n, dp);
        
    }
    public static int solve(int cr, int cc, int m , int n, int [][] dp){
        if(cr<0 || cc<0 || cr>=m || cc >=n){
            return 0;
        }

        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        if(cr==m-1 && cc==n-1){
            return 1;
        }

        int right=solve(cr,cc+1,m,n, dp);
        int down=solve(cr+1,cc,m,n, dp);
        return dp[cr][cc]= right+down;


    }
}