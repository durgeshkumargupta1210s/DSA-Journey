class Solution {

    // Function to find the minimum number of jumps to reach last index
    public int jump(int[] nums) {

        // If array has only one element, no jump is needed
        if (nums.length == 1) return 0;

        // maxReach = farthest index we can reach so far
        int maxReach = 0;

        // currentEnd = boundary of the current jump range
        int currentEnd = 0;

        // count = number of jumps taken
        int count = 0;

        // Traverse the array (we don't need to jump from last index)
        for (int i = 0; i < nums.length - 1; i++) {

            // Update maxReach to the farthest index reachable
            maxReach = Math.max(maxReach, i + nums[i]);

            // When we reach the end of the current jump range
            // we must take another jump
            if (i == currentEnd) {
                count++;              // increment jump count
                currentEnd = maxReach; // update jump boundary

                // If currentEnd already reaches last index, stop early
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        // Return minimum jumps required
        return count;
    }
}
