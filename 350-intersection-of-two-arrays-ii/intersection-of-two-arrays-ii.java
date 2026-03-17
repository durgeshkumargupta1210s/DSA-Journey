class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // HashMap to store frequency of elements from nums1
        // key   -> element
        // value -> number of times it appears
        Map<Integer, Integer> map = new HashMap<>();

        // List to store the intersection elements
        List<Integer> list = new ArrayList<>();

        // Step 1: Count frequency of each number in nums1
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        // Step 2: Traverse nums2 and check if element exists in map
        for(int i = 0; i < nums2.length; i++){

            // If the element exists and its frequency is still positive
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){

                // Add it to the intersection list
                list.add(nums2[i]);

                // Decrease its frequency since it is used once
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        // Step 3: Convert the list into an array
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        // Return the final intersection array
        return result;
    }
}