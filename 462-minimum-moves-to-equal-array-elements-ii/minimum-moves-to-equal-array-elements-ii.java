class Solution {
    public int minMoves2(int[] nums) {

        // Step 1: Sort the array
        // Sorting helps us easily pick the median element
        Arrays.sort(nums);

        // Step 2: Choose median
        // Median minimizes the sum of absolute differences (key insight)
        int median = nums[nums.length / 2];

        // Step 3: Calculate total moves
        int ops = 0;

        for (int i = 0; i < nums.length; i++) {
            // Each move increments/decrements by 1
            // So total moves = sum of absolute differences from median
            ops += Math.abs(nums[i] - median);
        }

        // Step 4: Return result
        return ops;
    }
}