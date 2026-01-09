class Solution {
    public int countHillValley(int[] nums) {

        int count = 0;
        int n = nums.length;

        // prev = last distinct element
        int prev = nums[0];

        for (int i = 1; i < n - 1; i++) {

            // Skip duplicate elements
            if (nums[i] == prev) {
                continue;
            }

            // Find next distinct element
            int next = nums[i + 1];
            int j = i + 1;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }

            // If no valid right neighbor exists
            if (j == n) break;

            next = nums[j];

            // Hill condition
            if (nums[i] > prev && nums[i] > next) {
                count++;
            }
            // Valley condition
            else if (nums[i] < prev && nums[i] < next) {
                count++;
            }

            // Update previous distinct value
            prev = nums[i];
        }

        return count;
    }
}
