class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Loop through all possible subsets
        for (int mask = 0; mask < (1 << n); mask++) {
            int xor = 0;

            // Check each bit
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    xor ^= nums[j];
                }
            }

            totalSum += xor;
        }

        return totalSum;
    }
}
