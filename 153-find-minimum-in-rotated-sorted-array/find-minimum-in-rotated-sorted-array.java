class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If middle element is greater than the rightmost,
            // it means the smallest value is to the right.
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                // Minimum is in the left part including mid
                high = mid;
            }
        }

        return nums[low]; // or nums[high], both are same here
    }
}
