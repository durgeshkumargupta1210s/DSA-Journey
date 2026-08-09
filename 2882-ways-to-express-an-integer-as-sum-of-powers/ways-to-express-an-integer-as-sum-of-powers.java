class Solution {
    static int[][] dp;
    static int MOD = 1000000007;

    public int numberOfWays(int n, int x) {

        dp = new int[n + 1][n + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solve(n, x, 1, n);
    }

    public static int solve(int n, int x, int idx, int target) {

        if (target == 0) {
            return 1;
        }

        if (idx > n) {
            return 0;
        }

        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        int skip = solve(n, x, idx + 1, target);

        int val = (int) Math.pow(idx, x);

        int take = 0;

        if (target >= val) {
            take = solve(n, x, idx + 1, target - val);
        }

        return dp[idx][target] = (skip + take) % MOD;
    }
}