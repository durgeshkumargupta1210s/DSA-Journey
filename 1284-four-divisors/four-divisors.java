class Solution {
    public int sumFourDivisors(int[] nums) {
        // Stores the final answer
        int ans = 0;

        // Process each number in the array
        for (int num : nums) {

            // Count of divisors of the current number
            int count = 0;

            // Sum of divisors of the current number
            int sum = 0;

            // Find divisors up to sqrt(num)
            for (int i = 1; i * i <= num; i++) {

                // Check if i is a divisor of num
                if (num % i == 0) {

                    int d1 = i;         // First divisor
                    int d2 = num / i;   // Corresponding divisor

                    // If both divisors are the same (perfect square case)
                    if (d1 == d2) {
                        count++;
                        sum += d1;
                    } else {
                        // Count both divisors and add them to the sum
                        count += 2;
                        sum += d1 + d2;
                    }

                    // No need to continue if divisors exceed 4
                    if (count > 4) {
                        break;
                    }
                }
            }

            // Add divisor sum only if the number has exactly 4 divisors
            if (count == 4) {
                ans += sum;
            }
        }

        // Return the total sum for all valid numbers
        return ans;
    }
}