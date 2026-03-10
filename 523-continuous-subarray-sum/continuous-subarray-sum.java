class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // premod will store the cumulative prefix sum modulo k
        int premod = 0;

        // HashMap to store the first index where a particular remainder appears
        // Key   -> remainder (prefixSum % k)
        // Value -> index where this remainder first occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case:
        // remainder 0 occurs at index -1 (before the array starts)
        // This helps detect subarrays starting from index 0
        map.put(0, -1);

        // Traverse the array
        for(int i = 0; i < nums.length; i++) {

            // Update prefix sum remainder
            // (previous remainder + current number) % k
            int mod = (premod + nums[i]) % k;

            // If this remainder has appeared before
            if(map.containsKey(mod)) {

                // Check if subarray length is at least 2
                // (problem requires size >= 2)
                if(i - map.get(mod) > 1){
                    return true;
                }
            }

            // Store the first occurrence of this remainder
            // We only store if it's not already present because
            // earlier index gives longer subarray
            if(!map.containsKey(mod)){
                map.put(mod, i);
            }

            // Update previous remainder
            premod = mod;
        }

        // If no valid subarray found
        return false;
    }
}