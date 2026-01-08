import java.util.*;

class Solution {
    int mod = 1_000_000_007;

    public int countHousePlacements(int n) {
        long[] dp = new long[n + 2];  
        Arrays.fill(dp, -1);

        long ans = countWays(0, n, dp);
        return (int) ((ans * ans) % mod);
    }

    public long countWays(int i, int n, long[] dp) {
        if (i >= n) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        long notTake = countWays(i + 1, n, dp);
        long take = countWays(i + 2, n, dp);

        return dp[i] = (take + notTake) % mod;
    }
}
