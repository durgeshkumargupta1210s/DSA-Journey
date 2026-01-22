class Solution {

    // Modulo constant as required by the problem
    static final long mod = 1_000_000_007;

    public int monkeyMove(int n) {

        /*
         Total possible ways for monkeys to move:
         Each monkey has 2 choices (stay or move),
         so total = 2^n
        */
        long total = modPow(2, n, mod);

        /*
         We subtract 2 because:
         - All monkeys stay in place
         - All monkeys move in the same direction
         These two configurations lead to no collision
        */
        long res = (total - 2 + mod) % mod;

        return (int) res;
    }

    /*
     Fast Modular Exponentiation (Binary Exponentiation)
     Computes (base^exp) % mod efficiently in O(log exp)
    */
    private long modPow(long base, long exp, long mod) {

        long res = 1;

        while (exp > 0) {

            // If current bit of exponent is set, multiply result
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }

            // Square the base for next bit
            base = (base * base) % mod;

            // Move to next bit of exponent
            exp >>= 1;
        }

        return res;
    }
}
