class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long[][] dp = new long[max + 1][max + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] next = new long[max + 1][max + 1];

            // Choice 1: Skip the current element
            for (int i = 0; i <= max; i++) {
                System.arraycopy(dp[i], 0, next[i], 0, max + 1);
            }

            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {
                    long ways = dp[g1][g2];
                    if (ways == 0) continue;

                    // Choice 2: Put x into first subsequence
                    int newG1 = (g1 == 0) ? x : gcd(g1, x);
                    next[newG1][g2] = (next[newG1][g2] + ways) % MOD;

                    // Choice 3: Put x into second subsequence
                    int newG2 = (g2 == 0) ? x : gcd(g2, x);
                    next[g1][newG2] = (next[g1][newG2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long ans = 0;
        for (int g = 1; g <= max; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}