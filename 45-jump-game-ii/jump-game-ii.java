class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, 0, dp);
    }

    public static int solve(int[] nums, int idx, int jumps, int[] dp) {

        if (idx >= nums.length - 1) {
            return jumps;
        }

        if (dp[idx] != -1) {
            return dp[idx] + jumps;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx]; i++) {

            if (idx + i < nums.length) {
                result = Math.min(result,
                        solve(nums, idx + i, jumps + 1, dp));
            }
        }

        dp[idx] = result - jumps;

        return result;
    }
}