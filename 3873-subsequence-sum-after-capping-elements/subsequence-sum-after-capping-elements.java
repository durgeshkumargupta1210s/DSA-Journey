import java.util.Arrays;

class Solution {

    /**
     * For each x from 1 to n:
     *  - Cap all elements in nums to at most x
     *  - Check if there exists a subsequence whose sum equals k
     *  - Store the result in ans[x - 1]
     */
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {

        int n = nums.length;
        boolean[] ans = new boolean[n];

        // Sort the array so that elements < x can be processed incrementally
        Arrays.sort(nums);

        /*
         * dp[s] = true if we can form sum 's' using
         * elements strictly smaller than the current cap 'x'
         */
        boolean[] dp = new boolean[k + 1];
        dp[0] = true; // Base case: sum 0 is always achievable

        // Pointer to track how many elements are < x
        int i = 0;

        /*
         * Iterate over each possible cap value x (1 to n)
         */
        for (int x = 1; x <= n; x++) {

            /*
             * Include all elements strictly smaller than x into the DP
             * Each such element contributes its original value
             */
            while (i < n && nums[i] < x) {
                int val = nums[i];

                // Standard 0/1 knapsack update (backward to avoid reuse)
                for (int s = k; s >= val; s--) {
                    dp[s] |= dp[s - val];
                }
                i++;
            }

            /*
             * Elements from index i to n-1 are >= x,
             * after capping they all become exactly x
             */
            int ncapped = n - i;

            /*
             * We can use at most:
             *  - ncapped elements (availability)
             *  - k / x elements (to not exceed sum k)
             */
            int maxUse = Math.min(ncapped, k / x);

            /*
             * Try using j capped elements (each contributes x)
             * Remaining sum = k - j*x
             * Check if that remainder is achievable using dp[]
             */
            for (int j = 0; j <= maxUse; j++) {
                if (dp[k - j * x]) {
                    ans[x - 1] = true;
                    break;
                }
            }
        }

        return ans;
    }
}
