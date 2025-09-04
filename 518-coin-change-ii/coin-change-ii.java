class Solution {
    public int change(int amount, int[] coins) {
        return Coin_ChangeBU(coins, amount);
    }

    public static int Coin_ChangeBU(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: 1 way to make 0 amount (choose nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill dp
        for (int i = 1; i <= n; i++) { // coins
            for (int am = 1; am <= amount; am++) { // amount
                int inc = 0, exc = 0;

                if (am >= coins[i - 1]) {
                    inc = dp[i][am - coins[i - 1]]; // include coin
                }

                exc = dp[i - 1][am]; // exclude coin

                dp[i][am] = inc + exc;
            }
        }

        return dp[n][amount];
    }
}
