class Solution {
    public int countBinaryPalindromes(long n) {

      
        if (n == 0) return 1;

        int count = 1; 

        int L = 64 - Long.numberOfLeadingZeros(n);

        
        for (int len = 1; len < L; len++) {
            int halfLen = (len + 1) / 2;
            count += 1 << (halfLen - 1);
        }

       
        int halfLen = (L + 1) / 2;

        long prefix = n >> (L - halfLen);
        long minPrefix = 1L << (halfLen - 1);

        count += (int)(prefix - minPrefix);

        if (makePalindrome(prefix, L % 2 == 1) <= n) {
            count++;
        }

        return count;
    }

    private long makePalindrome(long x, boolean odd) {
        long res = x;
        if (odd) x >>= 1;

        while (x > 0) {
            res = (res << 1) | (x & 1);
            x >>= 1;
        }
        return res;
    }
}
