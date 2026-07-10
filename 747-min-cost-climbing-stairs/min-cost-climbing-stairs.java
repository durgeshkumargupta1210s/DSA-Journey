class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp=new int [cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(0,cost,dp), solve(1,cost, dp));
        
    }
    public static int solve(int i, int [] cost, int [] dp ){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int take=cost[i]+Math.min(solve(i+1,cost, dp),solve(i+2, cost, dp));

        return dp[i]= take;
        
    }
}