import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberOfGoodSubsets(int[] nums) {

        int[] count = new int[31];
        for (int num : nums) count[num]++;

        int[] primes = {2,3,5,7,11,13,17,19,23,29};

        int[] masks = new int[31];
        for (int i = 2; i <= 30; i++) {
            int x = i;
            int mask = 0;
            boolean valid = true;

            for (int j = 0; j < primes.length; j++) {
                int p = primes[j];
                int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                if (cnt > 1) {   
                    valid = false;
                    break;
                }
                if (cnt == 1) {
                    mask |= (1 << j);
                }
            }

            masks[i] = valid ? mask : -1;
        }
        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int i = 2; i <= 30; i++) {
            if (count[i] == 0 || masks[i] == -1) continue;

            int curMask = masks[i];
            long[] next = dp.clone();

            for (int m = 0; m < (1 << 10); m++) {
                if ((m & curMask) == 0) {
                    next[m | curMask] =
                        (next[m | curMask] + dp[m] * count[i]) % MOD;
                }
            }

            dp = next;
        }

        long result = 0;
        for (int i = 1; i < (1 << 10); i++) {
            result = (result + dp[i]) % MOD;
        }

        int ones = count[1];
        long pow = modPow(2, ones);
        result = (result * pow) % MOD;

        return (int) result;
    }

    private long modPow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
