class Solution {

    /**
     * Counts subarrays that:
     * 1. Contain at least two prime numbers
     * 2. The difference between the maximum and minimum PRIME numbers
     *    in the subarray is <= k
     */
    public int primeSubarray(int[] nums, int k) {

        int n = nums.length;

        // st → right pointer of sliding window
        // end → left pointer of sliding window
        int st = 0, end = 0;

        // Final count of valid subarrays
        int ans = 0;

        // Number of prime elements inside current window
        int prime = 0;

        // Positions of last two primes encountered
        int lastPrimePos = -1;
        int secondLastPrimePos = -1;

        // Monotonic increasing deque (stores PRIME values only)
        // Front → minimum prime in window
        Deque<Integer> min = new ArrayDeque<>();

        // Monotonic decreasing deque (stores PRIME values only)
        // Front → maximum prime in window
        Deque<Integer> max = new ArrayDeque<>();

        // Expand window using st pointer
        while (st < n) {

            int num = nums[st];

            // Process only if current number is prime
            if (isPrime(num)) {

                prime++;

                // Update last two prime positions
                secondLastPrimePos = lastPrimePos;
                lastPrimePos = st;

                // Maintain increasing order in min deque
                while (!min.isEmpty() && min.peekLast() > num) {
                    min.pollLast();
                }
                min.addLast(num);

                // Maintain decreasing order in max deque
                while (!max.isEmpty() && max.peekLast() < num) {
                    max.pollLast();
                }
                max.addLast(num);
            }

            // Shrink window if maxPrime - minPrime exceeds k
            while (!min.isEmpty() && !max.isEmpty()
                    && max.peekFirst() - min.peekFirst() > k) {

                // Remove element leaving the window from deques
                if (nums[end] == min.peekFirst()) min.pollFirst();
                if (nums[end] == max.peekFirst()) max.pollFirst();

                // Decrease prime count if a prime is removed
                if (isPrime(nums[end])) prime--;

                end++;
            }

            /**
             * If there are at least 2 primes in the window:
             * Any subarray ending at 'st' and starting from
             * [end ... secondLastPrimePos] is valid
             */
            if (prime >= 2) {
                ans += Math.max(0, secondLastPrimePos - end + 1);
            }

            // Move right pointer
            st++;
        }

        return ans;
    }

    /**
     * Checks if a number is prime
     */
    public boolean isPrime(int el) {
        if (el <= 1) return false;

        for (int i = 2; i * i <= el; i++) {
            if (el % i == 0) return false;
        }
        return true;
    }
}
