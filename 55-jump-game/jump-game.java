class Solution {
    public boolean canJump(int[] nums) {
        
        // maxReach represents the farthest index we can reach so far
        int maxReach = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // ❌ If current index is beyond max reachable index,
            // it means we cannot reach this position → return false
            if (i > maxReach) {
                return false;
            }

            // ✅ Update maxReach:
            // From current index i, we can jump nums[i] steps
            // So the farthest we can go = i + nums[i]
            maxReach = Math.max(maxReach, i + nums[i]);

            // ✅ Optimization:
            // If we can already reach or cross the last index,
            // no need to continue → return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // If loop completes, we were able to traverse all reachable indices
        return true;
    }
}