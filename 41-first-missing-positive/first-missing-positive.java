class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean hasOne = false;

        // Step 1: Check if 1 is present, and sanitize array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) hasOne = true;
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (!hasOne) return 1;

        // Step 2: Use index as hash key and mark presence
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            nums[val - 1] = -Math.abs(nums[val - 1]);
        }

        // Step 3: Find first positive index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        // Step 4: If all indices are marked
        return n + 1;
    }
}
