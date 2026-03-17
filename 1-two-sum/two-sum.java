class Solution {
    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number and its index
        // Key   -> number from array
        // Value -> index of that number
        Map<Integer, Integer> map = new HashMap<>();

        // Length of the input array
        int n = nums.length;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Calculate the number required to reach the target
            // Example: target = 9, nums[i] = 2 → second = 7
            int second = target - nums[i];

            // Check if the required number already exists in the map
            if (map.containsKey(second)) {

                // If found, return the indices of the two numbers
                // map.get(second) gives index of the complement
                return new int[]{i, map.get(second)};
            }

            // Store the current number with its index in the map
            // This allows future elements to find it as their complement
            map.put(nums[i], i);
        }

        // If no valid pair is found (problem usually guarantees one),
        // return default values
        return new int[]{0, 0};
    }
}