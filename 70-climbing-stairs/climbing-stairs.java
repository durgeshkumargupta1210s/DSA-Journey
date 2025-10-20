class Solution {
    public int climbStairs(int n) {
        int [] dp=new int[n+1];
        return calculateStep(n, dp); 
        
    }
    public int calculateStep(int n, int [] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }

        int one_step=calculateStep(n-1,dp);
        int two_step=calculateStep(n-2, dp);

        return dp[n]=one_step+two_step;
    }
}