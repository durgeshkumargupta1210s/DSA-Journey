class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        // Length of the input array
        int n = nums.length;

        // Sliding window start index
        int si = 0;

        // Stores the maximum sum of a valid subarray of size k
        long max = 0;

        // Current window sum
        long sum = 0;

        // Set to maintain unique elements inside the window
        Set<Integer> set = new HashSet<>();

        /* ---------------------------------------------------------
           Sliding window using end index 'ei'
           --------------------------------------------------------- */
        for (int ei = 0; ei < n; ei++) {

            // If current element already exists in the window,
            // shrink the window from the start until it becomes unique
            while (set.contains(nums[ei])) {
                set.remove(nums[si]);     // remove duplicate-causing element
                sum -= nums[si];          // update sum
                si++;                     // move start pointer
            }

            // Add current element to the window
            set.add(nums[ei]);
            sum += nums[ei];

            // When window size becomes exactly k
            if (ei - si + 1 == k) {

                // Update maximum sum
                max = Math.max(max, sum);

                // Slide the window forward by removing the start element
                set.remove(nums[si]);
                sum -= nums[si];
                si++;
            }
        }

        // Return the maximum sum found
        return max;
    }
}
