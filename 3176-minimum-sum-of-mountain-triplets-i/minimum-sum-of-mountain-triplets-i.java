class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public int minimumSum(int[] nums) {

        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        // leftMin[i] = smallest value to the left of index i
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        // rightMin = smallest value to the right (tracked while iterating)
        int rightMin = Integer.MAX_VALUE;

        for (int j = n - 2; j > 0; j--) {

            rightMin = Math.min(rightMin, nums[j + 1]);

            // Check valid triplet condition
            if (leftMin[j - 1] < nums[j] && rightMin < nums[j]) {

                int sum = leftMin[j - 1] + nums[j] + rightMin;
                ans = Math.min(ans, sum);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
