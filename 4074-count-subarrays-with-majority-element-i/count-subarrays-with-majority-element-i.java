class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : 0);
        }

        int ans = 0;

        // Check every subarray
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int count = prefix[j + 1] - prefix[i];
                int len = j - i + 1;

                if (2 * count > len) {
                    ans++;
                }
            }
        }

        return ans;
    }
}