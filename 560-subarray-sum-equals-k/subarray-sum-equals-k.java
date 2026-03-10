class Solution {
    public int subarraySum(int[] nums, int k) {

        // Create prefix sum array where
        // prefixSum[i] = sum of elements from index 0 to i
        int[] prefixSum = new int[nums.length];

        // First element of prefix sum is same as nums[0]
        prefixSum[0] = nums[0];

        // Build the prefix sum array
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // HashMap to store frequency of prefix sums
        // Key = prefix sum value
        // Value = number of times this prefix sum has appeared
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum = 0 appears once
        // This helps when a subarray starting from index 0 equals k
        map.put(0, 1);

        // Variable to count number of valid subarrays
        int count = 0;

        // Traverse the prefix sum array
        for(int i = 0; i < nums.length; i++){

            // Current prefix sum
            int sum = prefixSum[i];

            // We want: currentPrefixSum - previousPrefixSum = k
            // So previousPrefixSum = currentPrefixSum - k
            int target = sum - k;

            // If such a prefix sum exists in the map,
            // it means a subarray with sum = k exists
            if(map.containsKey(target)){
                count += map.get(target);
            }

            // Update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return total number of subarrays with sum = k
        return count;
    }
}