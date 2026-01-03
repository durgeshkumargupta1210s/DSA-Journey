class Solution {

    public int kConcatenationMaxSum(int[] arr, int k) {

        // Total sum of one array
        long sum = 0;

        // Modulo value as per problem statement
        int mod = 1000000007;

        // -------------------------------
        // STEP 1: Calculate sum of array
        // -------------------------------
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // -------------------------------
        // STEP 2: If k == 1
        // -------------------------------
        // Simply apply Kadane's algorithm on original array
        if (k == 1) {
            return (int) (kadansAlgo(arr) % mod);
        }

        // -------------------------------
        // STEP 3: If k >= 2
        // -------------------------------
        // Create a new array by concatenating arr twice
        // Reason:
        // Maximum subarray can span across at most two copies
        int[] temp = new int[2 * arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
            temp[i + arr.length] = arr[i];
        }

        // Apply Kadane’s algorithm on the double array
        long ans = kadansAlgo(temp);

        // -------------------------------
        // STEP 4: If total sum is positive
        // -------------------------------
        // Middle (k - 2) arrays can be fully added
        if (sum > 0) {
            ans = ans + (k - 2) * sum;
        }

        // Return result under modulo
        return (int) (ans % mod);
    }

    // -------------------------------
    // Kadane’s Algorithm
    // -------------------------------
    // Finds maximum subarray sum
    public long kadansAlgo(int[] arr) {

        long ans = 0;   // Stores maximum sum so far
        long sum = 0;   // Stores current subarray sum

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If current sum becomes negative, reset it
            if (sum < 0) {
                sum = 0;
            }

            // Update maximum sum
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
