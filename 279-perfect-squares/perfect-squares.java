class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    public int solve(int target, int[] dp) {

        if (target == 0)
            return 0;

        if (dp[target] != -1)
            return dp[target];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i * i <= target; i++) {

            int temp = solve(target - i * i, dp);

            if (temp != Integer.MAX_VALUE)
                ans = Math.min(ans, temp + 1);
        }

        return dp[target] = ans;
    }
}