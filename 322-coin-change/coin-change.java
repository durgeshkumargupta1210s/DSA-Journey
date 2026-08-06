class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp=new int[amount+1][coins.length];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }

        int ans=solve(coins,amount,0, dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static int solve(int [] coins, int amount,int idx, int [][] dp){
        if(amount==0){
            return 0;
        }

        
        if(idx==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }

        int include=Integer.MAX_VALUE;
        if(amount>=coins[idx]){
            int res=solve(coins,amount-coins[idx], idx, dp);

            if(res!=Integer.MAX_VALUE){
                include=res+1;
            }
        }

        int exclude=solve(coins,amount,idx+1, dp);

        return dp[amount][idx]= Math.min(include,exclude);
    }
}