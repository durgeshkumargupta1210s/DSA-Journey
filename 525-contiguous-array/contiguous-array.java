class Solution {
    public int findMaxLength(int[] nums) {

        // HashMap to store prefixSum -> first index where this sum appears
        Map<Integer, Integer> map = new HashMap<>();

        // Variable to store maximum length of subarray with equal 0s and 1s
        int maxLen = 0;

        // Base case: prefix sum 0 occurs before the array starts
        // This helps handle cases where valid subarray starts from index 0
        map.put(0, -1);

        // Step 1: Convert 0 to -1 and keep 1 as 1
        // This allows us to use prefix sum to detect equal number of 0s and 1s
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
            else{
                nums[i] = 1;
            }
        }

        // Step 2: Compute prefix sum array
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Step 3: Traverse prefixSum and check if the same sum appeared before
        for(int i = 0; i < nums.length; i++){

            int sum = prefixSum[i];

            // If this prefix sum was seen before,
            // it means the subarray between those indices has sum = 0
            // which implies equal number of 0s and 1s
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            }

            // Store the index of this prefix sum
            if(!map.containsKey(sum)){
    map.put(sum, i);
}
        }

        // Return the maximum length found
        return maxLen;
    }
}