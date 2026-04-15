class Solution {
    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        // dp[i] → maximum number of indices we can visit starting from index i
        int[] dp = new int[n];

        // Initialize with -1 (means not yet computed)
        Arrays.fill(dp, -1);

        int result = 0;

        // Try starting from every index
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(arr, i, d, dp));
        }

        return result;
    }

    public static int dfs(int[] arr, int i, int d, int[] dp) {

        // ✅ If already computed, return stored result (memoization)
        if (dp[i] != -1) {
            return dp[i];
        }

        // At least we can stay at current index → count = 1
        int max = 1;

        // 🔹 Explore RIGHT side (i+1 to i+d)
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1); j++) {

            // ❌ Stop if we hit a taller or equal height
            // (cannot jump beyond this point)
            if (arr[j] >= arr[i]) break;

            // ✅ Try jumping and update max path
            max = Math.max(max, 1 + dfs(arr, j, d, dp));
        }

        // 🔹 Explore LEFT side (i-1 to i-d)
        for (int j = i - 1; j >= Math.max(i - d, 0); j--) {

            // ❌ Same restriction: stop if blocked
            if (arr[j] >= arr[i]) break;

            // ✅ Try jumping and update max path
            max = Math.max(max, 1 + dfs(arr, j, d, dp));
        }

        // Store result in dp and return
        return dp[i] = max;
    }
}