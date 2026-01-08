class Solution {

    public boolean isZeroArray(int[] nums, int[][] queries) {

        // Difference array to efficiently apply range increments
        // Size is nums.length + 1 to safely handle r + 1 index
        int[] diff = new int[nums.length + 1];

        // Process each query [l, r]
        // Each query allows us to decrement nums[l..r] by 1
        for (int[] arr : queries) {
            int l = arr[0];  // left index
            int r = arr[1];  // right index

            // Start decrement effect at index l
            diff[l] += 1;

            // End decrement effect after index r
            if (r + 1 < nums.length) {
                diff[r + 1] -= 1;
            }
        }

        // Variable to store prefix sum of difference array
        // This represents total decrements available at index i
        int count = 0;

        // Traverse the nums array
        for (int i = 0; i < nums.length; i++) {

            // Accumulate the difference array
            count += diff[i];

            // If available decrements are less than nums[i],
            // we cannot reduce nums[i] to zero
            if (count < nums[i]) {
                return false;
            }
        }

        // All elements can be reduced to zero
        return true;
    }
}
