class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long pow5 = modPow(5, evenCount);
        long pow4 = modPow(4, oddCount);

        return (int)((pow5 * pow4) % MOD);
    }

    private static long modPow(long base, long exp) {
    if (exp == 0) return 1;
    long half = modPow(base, exp / 2) % MOD;
    long result = (half * half) % MOD;
    if (exp % 2 == 1) result = (result * base) % MOD;
    return result;
    }
}
