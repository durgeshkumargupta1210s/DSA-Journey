class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Sort the array first
        // Sorting helps us apply the two-pointer technique efficiently
        Arrays.sort(nums);

        // Use a HashSet to store unique triplets
        // This prevents duplicate combinations like [-1,0,1] appearing multiple times
        Set<List<Integer>> set = new HashSet<>();

        // Iterate through the array and fix one element at a time
        for (int i = 0; i < nums.length; i++) {

            // Left pointer starts just after the fixed element
            int left = i + 1;

            // Right pointer starts from the end of the array
            int right = nums.length - 1;

            // Apply two-pointer approach to find remaining two numbers
            while (left < right) {

                // Calculate the sum of the current triplet
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum equals zero, we found a valid triplet
                if (sum == 0) {

                    // Add the triplet to the set to avoid duplicates
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers to search for other possible pairs
                    left++;
                    right--;
                }

                // If sum is smaller than zero, increase it by moving left pointer
                else if (sum < 0) {
                    left++;
                }

                // If sum is greater than zero, decrease it by moving right pointer
                else {
                    right--;
                }
            }
        }

        // Convert the set into a list and return the result
        return new ArrayList<>(set);
    }
}