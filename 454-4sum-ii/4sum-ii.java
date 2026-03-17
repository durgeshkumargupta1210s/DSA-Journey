class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // HashMap to store the frequency of sums formed by nums1 and nums2
        // key   -> sum of two numbers
        // value -> number of times this sum appears
        Map<Integer, Integer> map = new HashMap<>();

        // Variable to store total number of valid tuples
        int count = 0;

        // Step 1: Calculate all possible sums of nums1[i] + nums2[j]
        // and store their frequency in the HashMap
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){

                // Sum of elements from first two arrays
                int sum = nums1[i] + nums2[j];

                // Increase frequency of this sum in the map
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Step 2: Check all sums of nums3[k] + nums4[l]
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){

                // Sum of elements from third and fourth arrays
                int sum = nums3[i] + nums4[j];

                // To make total sum = 0, we need the opposite value
                int target = -sum;

                // If this target sum exists in the map,
                // it means nums1 + nums2 can cancel nums3 + nums4
                if(map.containsKey(target)){

                    // Add its frequency to the count
                    count += map.get(target);
                }
            }
        }

        // Return the total number of valid tuples
        return count;
    }
}