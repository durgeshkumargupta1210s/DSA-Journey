class Solution {

    // Returns the minimum number of queries needed
    // to make the array nums a zero array
    public int minZeroArray(int[] nums, int[][] queries) {

        int n = queries.length;

        // Binary search on number of queries used
        int low = 0;
        int high = n;

        // Stores the minimum valid index
        int ans = -1;

        while (low <= high) {

            // Mid represents how many queries we are testing
            int mid = low + (high - low) / 2;

            // Check if first 'mid' queries are sufficient
            if (canMakeZero(nums, queries, mid)) {
                ans = mid;          // valid answer found
                high = mid - 1;     // try to minimize queries
            } else {
                low = mid + 1;      // need more queries
            }
        }

        return ans;
    }

    // Checks whether the first 'k' queries can reduce nums to zero
    public boolean canMakeZero(int[] nums, int[][] q, int k) {

        // Difference array to track total decrement capacity
        int[] diff = new int[nums.length + 1];

        // Apply the first k queries
        for (int i = 0; i < k; i++) {

            int left = q[i][0];
            int right = q[i][1];
            int val = q[i][2];

            // Start adding decrement capacity at 'left'
            diff[left] += val;

            // Stop adding capacity after 'right'
            if (right + 1 < nums.length) {
                diff[right + 1] -= val;
            }
        }

        // Prefix sum gives total decrement capacity at each index
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += diff[i];

            // If available decrement is less than required,
            // nums[i] cannot be reduced to zero
            if (sum < nums[i]) {
                return false;
            }
        }

        // All indices can be reduced to zero
        return true;
    }
}
