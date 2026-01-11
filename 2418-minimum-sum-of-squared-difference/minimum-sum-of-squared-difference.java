class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        int MAX = 100000;
        long[] freq = new long[MAX + 1];

        // Step 1: build difference frequency
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
        }

        // Step 2: greedy reduction from largest difference
        for (int d = MAX; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;

            long take = Math.min(freq[d], k);

            freq[d] -= take;
            freq[d - 1] += take;
            k -= take;
        }

        // Step 3: compute sum of squares
        long ans = 0;
        for (int d = 0; d <= MAX; d++) {
            if (freq[d] > 0) {
                ans += freq[d] * (long) d * d;
            }
        }

        return ans;
    }
}
