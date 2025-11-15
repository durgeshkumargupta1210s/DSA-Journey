class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int ansTopDown = topDownCoinChange(coins, amount, coins.length - 1, dp);
        if (ansTopDown >= 100000000) ansTopDown = -1;
        return ansTopDown;
        
    }
    private static int topDownCoinChange(int[] coins, int amount, int idx, int[][] dp) {

        // BASE CASE: only smallest coin left
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];   // exact divisible case
            }
            return 100000000;               // impossible -> return large value
        }

        // MEMOIZATION CHECK
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        // ---------------------------
        // OPTION 1: EXCLUDE CURRENT COIN → move to previous coin
        // ---------------------------
        int exclude = topDownCoinChange(coins, amount, idx - 1, dp);

        // ---------------------------
        // OPTION 2: INCLUDE CURRENT COIN → stay on same coin index
        // ---------------------------
        int include = 100000000;
        if (coins[idx] <= amount) {
            include = 1 + topDownCoinChange(coins, amount - coins[idx], idx, dp);
        }

        // STORE & RETURN RESULT
        return dp[idx][amount] = Math.min(exclude, include);
    }
}