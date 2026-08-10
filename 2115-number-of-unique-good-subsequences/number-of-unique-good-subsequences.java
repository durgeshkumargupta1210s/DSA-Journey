class Solution {

    public int numberOfUniqueGoodSubsequences(String binary) {

        long one = 0;
        long zero = 0;

        boolean hasZero = false;

        long mod = 1000000007;

        for (int i = 0; i < binary.length(); i++) {

            char ch = binary.charAt(i);

            if (ch == '1') {

                one = (one + zero + 1) % mod;

            } else {

                zero = (zero + one) % mod;

                hasZero = true;
            }
        }

        long ans = (one + zero) % mod;

        if (hasZero) {
            ans = (ans + 1) % mod;
        }

        return (int) ans;
    }
}