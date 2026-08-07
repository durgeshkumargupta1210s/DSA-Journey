class Solution {

    static int[][] lenDp;
    static int[][] cntDp;

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        lenDp = new int[n][n + 1];
        cntDp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(lenDp[i], -1);
            Arrays.fill(cntDp[i], -1);
        }

        int maxLen = solveLen(nums, 0, -1);
        return solveCount(nums, 0, -1, maxLen);
    }

    // Returns maximum length
    public static int solveLen(int[] nums, int idx, int prev) {

        if (idx == nums.length)
            return 0;

        if (lenDp[idx][prev + 1] != -1)
            return lenDp[idx][prev + 1];

        int skip = solveLen(nums, idx + 1, prev);

        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + solveLen(nums, idx + 1, idx);
        }

        return lenDp[idx][prev + 1] = Math.max(skip, take);
    }

    // Returns number of LIS having required length
    public static int solveCount(int[] nums, int idx, int prev, int need) {

        if (need == 0)
            return 1;

        if (idx == nums.length)
            return 0;

        if (cntDp[idx][prev + 1] != -1)
            return cntDp[idx][prev + 1];

        int ans = 0;

        // Take
        if (prev == -1 || nums[idx] > nums[prev]) {
            if (1 + solveLen(nums, idx + 1, idx) == need)
                ans += solveCount(nums, idx + 1, idx, need - 1);
        }

        // Skip
        if (solveLen(nums, idx + 1, prev) == need)
            ans += solveCount(nums, idx + 1, prev, need);

        return cntDp[idx][prev + 1] = ans;
    }
}