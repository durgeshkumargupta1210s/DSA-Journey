class Solution {

    // Returns the length of the Longest Increasing Subsequence (LIS)
    public int lengthOfLIS(int[] nums) {

        // dp[i] will store the minimum possible tail value
        // of an increasing subsequence of length (i + 1)
        int[] dp = new int[nums.length];

        // Length of the LIS found so far
        int len = 1;

        // First element always forms a subsequence of length 1
        dp[0] = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {

            // Case 1: Current element extends the longest subsequence
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            }

            // Case 2: Current element replaces a larger element
            // to maintain the smallest possible tail value
            else {
                int idx = binarySearch(dp, nums[i], len);
                dp[idx] = nums[i];
            }
        }

        // Length of LIS
        return len;
    }

    // Custom binary search to find the first index
    // where dp[index] >= target (Lower Bound)
    public int binarySearch(int[] dp, int target, int len) {

        int low = 0;
        int high = len - 1;

        // Stores the position where target should be placed
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If dp[mid] is greater than or equal to target,
            // move left to find the first such position
            if (dp[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            // Otherwise, search in the right half
            else {
                low = mid + 1;
            }
        }

        // Lower bound index
        return ans;
    }
}
