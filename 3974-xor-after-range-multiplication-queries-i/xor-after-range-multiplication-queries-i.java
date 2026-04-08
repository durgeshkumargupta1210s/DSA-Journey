class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int mod = 1000000007;

        long[] mul = new long[n];
        Arrays.fill(mul, 1);

        // Process queries
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int i = l; i <= r; i += k) {
                mul[i] = (mul[i] * v) % mod;
            }
        }

        long xor = 0;

        for (int i = 0; i < n; i++) {
            long val = (nums[i] * mul[i]) % mod;
            xor ^= val;
        }

        return (int) xor;
    }
}