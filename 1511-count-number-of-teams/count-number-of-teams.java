class Solution {

    // Main function to count the number of valid teams
    public int numTeams(int[] rating) {

        /*
         dp[i][cnt][pInd+1]
         i     → current index in array
         cnt   → number of elements selected so far
         pInd  → previous selected index (-1 means no previous element)
         +1 is used to handle pInd = -1 safely
        */
        int dp[][][] = new int[rating.length][4][rating.length];

        // Initialize DP array with -1 (uncomputed state)
        for (int i[][] : dp) {
            for (int j[] : i) {
                Arrays.fill(j, -1);
            }
        }

        // Count strictly increasing teams
        int inc = helper(0, rating, 0, -1, dp);

        // Reset DP for decreasing case
        dp = new int[rating.length][4][rating.length];
        for (int i[][] : dp) {
            for (int j[] : i) {
                Arrays.fill(j, -1);
            }
        }

        // Reverse the rating array to reuse the same logic
        int rev[] = new int[rating.length];
        int k = 0;
        for (int i = rating.length - 1; i >= 0; i--) {
            rev[k++] = rating[i];
        }

        // Count strictly decreasing teams
        int dec = helper(0, rev, 0, -1, dp);

        // Total teams = increasing + decreasing
        return inc + dec;
    }

    // Recursive helper function with memoization
    public int helper(int i, int arr[], int cnt, int pInd, int dp[][][]) {

        // Base case: if 3 elements are selected, a valid team is formed
        if (cnt == 3) {
            return 1;
        }

        // If we reach the end of array without forming a team
        if (i >= arr.length) {
            return 0;
        }

        // If the result is already computed, return it
        if (dp[i][cnt][pInd + 1] != -1) {
            return dp[i][cnt][pInd + 1];
        }

        int include = 0;

        // Option 1: Include current element
        // Allowed if no previous element OR current > previous (strictly increasing)
        if (pInd == -1 || arr[pInd] < arr[i]) {
            include = helper(i + 1, arr, cnt + 1, i, dp);
        }

        // Option 2: Exclude current element
        int exclude = helper(i + 1, arr, cnt, pInd, dp);

        // Store and return the result
        return dp[i][cnt][pInd + 1] = include + exclude;
    }
}
