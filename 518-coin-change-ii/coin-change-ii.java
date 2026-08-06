class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp=new int[amount+1][coins.length];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }
        return solve(amount,coins, 0, dp);

    }
    public static int solve(int amount, int [] coins, int idx, int [][] dp){
        if(amount==0){
            return 1;
        }

        if(idx>=coins.length){
            return 0;
        }

        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }

        int skip=solve(amount,coins,idx+1, dp);
        int take=0;
        if(amount>=coins[idx]){
            take=solve(amount-coins[idx], coins,idx, dp);
        }
        

        return dp[amount][idx]= skip+take;
    }
}