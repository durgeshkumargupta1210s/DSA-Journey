class Solution {
    public int maxFrequency(int[] nums, int k) {

        // Sort the array so we can make smaller elements
        // equal to larger elements efficiently
        Arrays.sort(nums);

        // Left pointer of sliding window
        int left = 0;

        // Stores maximum possible frequency
        int ans = 0;

        // Stores sum of current window elements
        long curr = 0;

        // Expand the window using right pointer
        for (int right = 0; right < nums.length; right++) {

            // Current target element
            // We try to make all elements in window equal to nums[right]
            long target = nums[right];

            // Add current element to window sum
            curr += target;

            /*
                Cost required to make all elements equal to target:

                required = windowSize * target - currentSum

                If required operations exceed k,
                shrink window from left side
            */
            while ((right - left + 1) * target - curr > k) {

                // Remove left element from current sum
                curr -= nums[left];

                // Shrink window
                left++;
            }

            // Update maximum valid window size
            ans = Math.max(ans, right - left + 1);
        }

        // Return maximum frequency possible
        return ans;
    }
}