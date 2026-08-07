class Solution {

    int[][] dp;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        dp = new int[nums.size()][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -2);

        int ans = solve(nums, target, 0);

        return ans < 0 ? -1 : ans;
    }

    public int solve(List<Integer> nums, int target, int idx) {

        if (target == 0)
            return 0;

        if (idx == nums.size())
            return Integer.MIN_VALUE;

        if (dp[idx][target] != -2)
            return dp[idx][target];

        int skip = solve(nums, target, idx + 1);

        int take = Integer.MIN_VALUE;

        if (target >= nums.get(idx)) {

            take = solve(nums, target - nums.get(idx), idx + 1);

            if (take != Integer.MIN_VALUE)
                take++;
        }

        return dp[idx][target] = Math.max(skip, take);
    }
}