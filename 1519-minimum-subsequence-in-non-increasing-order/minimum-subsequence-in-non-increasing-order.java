class Solution {
    public List<Integer> minSubsequence(int[] nums) {

        // Sort the array in ascending order
        // This allows us to select elements starting from the largest value
        Arrays.sort(nums);

        // List to store the resulting subsequence
        List<Integer> list = new ArrayList<>();

        // Calculate the total sum of all elements in the array
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        // Sum of elements included in the subsequence
        int sum = 0;

        /*
         * Traverse the array from the largest element to the smallest.
         * Greedily add elements to the subsequence until its sum
         * becomes strictly greater than the sum of remaining elements.
         */
        for (int i = nums.length - 1; i >= 0; i--) {

            // Add the current largest element to the subsequence
            list.add(nums[i]);
            sum += nums[i];

            // Subtract the current element from the remaining total sum
            total = total - nums[i];

            // Stop when the subsequence sum is greater than the remaining sum
            if (total < sum) {
                break;
            }
        }

        // Return the subsequence with the minimum number of elements
        // whose sum is greater than the sum of the remaining elements
        return list;
    }
}
