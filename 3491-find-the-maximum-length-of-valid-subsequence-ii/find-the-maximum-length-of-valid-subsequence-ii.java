class Solution {
    public int maximumLength(int[] nums, int k) {

        int[][] dp = new int[k][k];
        int ans = 1;

        for (int num : nums) {
            int r = num % k;

            for (int prev = 0; prev < k; prev++) {
                dp[r][prev] = Math.max(dp[r][prev], dp[prev][r] + 1);
                ans = Math.max(ans, dp[r][prev]);
            }
        }

        return ans;
    }
}
