class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // si = start index of sliding window
        int si = 0;
        // ans stores the minimum length found; start with infinity
        int ans = Integer.MAX_VALUE;
        // sum stores the sum of the current window
        int sum = 0;

        // ei = end index of sliding window
        for (int ei = 0; ei < nums.length; ei++) {
            sum += nums[ei]; // add current element to window sum

            // Shrink the window from the left while the sum >= target
            while (sum >= target) {
                // Update minimum length
                ans = Math.min(ans, ei - si + 1);
                // Remove the leftmost element from sum and move start index forward
                sum -= nums[si];
                si++;
            }
        }

        // If ans was never updated, return 0 (no valid subarray found)
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
