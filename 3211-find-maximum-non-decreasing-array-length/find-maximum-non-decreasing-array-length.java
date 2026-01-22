class Solution {

    public int findMaximumLength(int[] nums) {

        int n = nums.length;

        // pre[j] stores the minimum index i such that
        // dp[j] can safely transition from dp[i]
        int[] pre = new int[n + 2];

        // dp[j] = maximum number of valid segments considering
        // the first j elements
        int[] dp = new int[n + 1];

        // acc[i] = prefix sum of first i elements
        // acc[0] = 0
        long[] acc = new long[n + 1];

        // Build prefix sum array
        for (int i = 1; i <= n; i++) {
            acc[i] = acc[i - 1] + nums[i - 1];
        }

        // i represents the left boundary for valid partitioning
        for (int i = 0, j = 1; j <= n; j++) {

            // Ensure i respects all previous constraints
            i = Math.max(i, pre[j]);

            // We can form one more valid segment ending at j
            dp[j] = dp[i] + 1;

            /*
             We want to ensure the next segment has a sum
             >= current segment sum.

             Current segment sum = acc[j] - acc[i]

             Condition for next segment:
             acc[k] - acc[j] >= acc[j] - acc[i]

             Rearranging:
             acc[k] >= 2 * acc[j] - acc[i]
            */
            int k = Arrays.binarySearch(acc, 2 * acc[j] - acc[i]);

            // If exact value not found, binarySearch returns
            // -(insertionPoint) - 1
            if (k < 0) {
                k = -k - 1;
            }

            // From index k onward, the next partition must start
            // at position j
            pre[k] = j;
        }

        // dp[n] contains the maximum number of valid segments
        return dp[n];
    }
}
