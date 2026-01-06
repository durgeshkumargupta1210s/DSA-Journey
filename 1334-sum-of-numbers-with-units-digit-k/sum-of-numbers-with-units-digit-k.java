class Solution {
    public int minimumNumbers(int num, int k) {

        // If the target sum is 0, we need 0 numbers to form the sum
        if (num == 0) {
            return 0;
        }

        // Special case: if k == 0
        // Only numbers allowed are multiples of 10 (ending with 0)
        // So num must also end with 0 to be possible
        if (k == 0) {
            return num % 10 == 0 ? 1 : -1;
        }

        // Try using i numbers (each ending with digit k)
        // Maximum i required is 10 because last digits repeat every 10
        for (int i = 1; i * k <= num && i <= 10; i++) {

            // Subtract i numbers each ending with k from num
            // If the remaining value ends with 0, it can be formed
            // by adding numbers ending with 0 (i.e., multiples of 10)
            if ((num - (k * i)) % 10 == 0) {
                return i; // Minimum count found
            }
        }

        // If no valid combination is found, return -1
        return -1;
    }
}
