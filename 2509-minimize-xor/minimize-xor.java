class Solution {
    public int minimizeXor(int num1, int num2) {
        return find_x(num1, num2);
    }
    public static int find_x(int num1, int num2) {

        // Count number of set bits in num2
        int set_bit = 0;

        /*
         * Brian Kernighan’s Algorithm:
         * Each iteration removes the rightmost set bit
         */
        while (num2 > 0) {
            num2 = (num2 & (num2 - 1));
            set_bit++;
        }

        // This variable will store the result value x
        int x = 0;

        /*
         * First pass (from MSB to LSB):
         * Try to match set bits of num1 to minimize XOR
         */
        for (int i = 30; i >= 0; i--) {

            // Create mask for the i-th bit
            int mask = (1 << i);

            // If num1 has a set bit at position i
            if ((num1 & mask) != 0) {

                // Set the same bit in x
                x |= mask;
                set_bit--;

                // Stop once required number of set bits is reached
                if (set_bit == 0) {
                    return x;
                }
            }
        }

        /*
         * Second pass (from LSB to MSB):
         * Fill remaining set bits in positions where num1 has 0
         */
        for (int i = 0; i <= 30; i++) {

            int mask = (1 << i);

            // Choose positions where num1 has 0
            if ((num1 & mask) == 0) {

                // Set bit in x
                x |= mask;
                set_bit--;

                // Stop when all required bits are placed
                if (set_bit == 0) {
                    return x;
                }
            }
        }

        // Return the constructed value x
        return x;
    }
}