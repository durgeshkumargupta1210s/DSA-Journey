class Solution {
    public long minEnd(int n, int x) {

        long result = x;
        long remaining = n - 1;   
        long base = x;

        int bit = 0;

        while (remaining > 0) {

            if (((base >> bit) & 1) == 0) {

                if ((remaining & 1) == 1) {
                    result |= (1L << bit);
                }

                remaining >>= 1;
            }

            bit++;
        }

        return result;
    }
}
