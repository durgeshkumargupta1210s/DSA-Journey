class Solution {
    public int maxSubArray(int[] nums) {

        // ans will store the maximum subarray sum found so far.
        // Initialized with the smallest possible integer value
        // to correctly handle cases where all elements are negative.
        int ans = Integer.MIN_VALUE;

        // sum stores the sum of the current subarray.
        int sum = 0;

        // Traverse the array once
        for(int i = 0; i < nums.length; i++){

            // Add the current element to the running sum
            sum += nums[i];

            // Update the maximum subarray sum if the current sum is larger
            ans = Math.max(ans, sum);

            // If the running sum becomes negative,
            // it will reduce the sum of future subarrays.
            // So we reset the sum to 0 and start a new subarray.
            if(sum < 0){
                sum = 0;
            }
        }

        // Return the maximum subarray sum found
        return ans;
    }
}