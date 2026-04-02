class Solution {
    public int maximumAmount(int[][] coins) {
        Integer[][][] dp = new Integer[coins.length][coins[0].length][3];
        return maximum(coins, 0, 0, 2, dp);
    }

    public static int maximum(int[][] coins, int sr, int sc, int count, Integer[][][] dp) {
        if (sr >= coins.length || sc >= coins[0].length) {
            return Integer.MIN_VALUE;
        }

        if (sr == coins.length - 1 && sc == coins[0].length - 1) {
            if (coins[sr][sc] < 0 && count > 0) {
                return 0;
            }
            return coins[sr][sc];
        }

        if (dp[sr][sc][count] != null) {
            return dp[sr][sc][count];
        }

        int result;
        if (coins[sr][sc] < 0) {
            int take = coins[sr][sc]
                    + Math.max(maximum(coins, sr + 1, sc, count, dp), maximum(coins, sr, sc + 1, count, dp));

            int notTake = Integer.MIN_VALUE;
            ;

            if (count > 0) {
                notTake = Math.max(maximum(coins, sr + 1, sc, count - 1, dp),
                        maximum(coins, sr, sc + 1, count - 1, dp));
            }

            result = Math.max(take, notTake);
        } else {
            result = coins[sr][sc]
                    + Math.max(maximum(coins, sr + 1, sc, count, dp), maximum(coins, sr, sc + 1, count, dp));
        }

        return dp[sr][sc][count] = result;

    }
}