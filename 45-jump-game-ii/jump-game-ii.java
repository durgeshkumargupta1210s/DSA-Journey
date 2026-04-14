class Solution {
    public int jump(int[] nums) {

        // jumps → number of jumps taken to reach the end
        int jumps = 0;

        // end → end of current range (boundary of current jump)
        int end = 0;

        // farthest → farthest index we can reach within current range
        int farthest = 0;

        // We iterate till n-1 because once we reach last index,
        // no need to jump further
        for (int i = 0; i < nums.length - 1; i++) {

            // From index i, update the farthest we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of current jump range
            if (i == end) {

                // We must take a jump
                jumps++;

                // Update the new range boundary for next jump
                end = farthest;
            }
        }

        // Return total jumps needed to reach last index
        return jumps;
    }
}