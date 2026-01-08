import java.util.*;

class Solution {

    // Modulo constant as required by the problem
    int mod = 1_000_000_007;

    // Main function that returns total house placement combinations
    public int countHousePlacements(int n) {

        /*
         dp[i] stores the number of valid ways to place houses
         starting from index i on ONE side of the road.
         
         Size is n + 2 to safely handle i + 2 indexing.
        */
        long[] dp = new long[n + 2];

        // Initialize dp array with -1 to mark uncomputed states
        Arrays.fill(dp, -1);

        // Count ways for one side of the road
        long ans = countWays(0, n, dp);

        /*
         Since both sides of the road are independent,
         total ways = (ways on one side)²
        */
        return (int) ((ans * ans) % mod);
    }

    // Recursive function to count valid house placements
    public long countWays(int i, int n, long[] dp) {

        /*
         Base Case:
         If index goes beyond the last plot,
         this represents a valid placement.
        */
        if (i >= n) {
            return 1;
        }

        // If already computed, return cached result
        if (dp[i] != -1) {
            return dp[i];
        }

        /*
         Option 1: Do NOT place a house at index i
         Move to the next plot
        */
        long notTake = countWays(i + 1, n, dp);

        /*
         Option 2: Place a house at index i
         Skip next plot to avoid adjacent houses
        */
        long take = countWays(i + 2, n, dp);

        // Store and return the result for index i
        return dp[i] = (take + notTake) % mod;
    }
}
