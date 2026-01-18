class Solution {

/*
    My Approach

    Gives TLE for this question but works well for the
    same question(3129) were the constrains were small.

    static int l;
    static int dp[][][][];
    static int mod = 1000000007;
    static int helper(int zero, int one, int conseq, int prev){
        if(dp[zero][one][prev][conseq]!=-1) return dp[zero][one][prev][conseq]%mod;

        int ans = 0;
        if(zero==0 && one==0) return 1;
        if(zero>0){
            if(prev==0 && conseq<l){
                ans = ans+helper(zero-1,one,conseq+1,0);
            }
            if(prev==1) ans = ans+helper(zero-1,one,1,0);
        }
        if(one>0){
            if(prev==1 && conseq<l){
                ans = ans+helper(zero,one-1,conseq+1,1);
            }
            if(prev==0) ans = ans+helper(zero,one-1,1,1);
        }
        return dp[zero][one][prev][conseq] = ans%mod;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        l = limit;
        dp = new int[zero+1][one+1][2][l+1];
        for(var a : dp) for(var b : a) for(var c : b) Arrays.fill(c,-1);
        int a = helper(zero-1,one,1,0)%mod;
        int b = helper(zero,one-1,1,1)%mod;
        return (a+b)%mod;
    }

    */
    int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); i++){
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= Math.min(one, limit); i++){
            dp[0][i][1] = 1;
        }


        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit){
                    dp[i][j][0] = (dp[i][j][0] + MOD - dp[i - limit - 1][j][1]) % MOD;
                }
                
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit){
                    dp[i][j][1] = (dp[i][j][1] + MOD - dp[i][j - limit - 1][0]) % MOD;
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}