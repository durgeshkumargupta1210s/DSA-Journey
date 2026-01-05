class Solution {

    // job[i] = {startTime, endTime, profit} for the i-th job
    int[][] job;

    // dp[i] stores the maximum profit achievable starting from job index i
    int[] dp;

    // Total number of jobs
    int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        // Number of jobs
        n = startTime.length;

        // Create a 2D array to store job details together
        job = new int[n][3];

        // Fill job array: start time, end time, and profit
        for (int i = 0; i < job.length; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        // Sort jobs by start time
        // This allows binary search for the next non-overlapping job
        Arrays.sort(job, (a, b) -> a[0] - b[0]);

        // dp[i] = -1 indicates that the value is not computed yet
        dp = new int[n];
        Arrays.fill(dp, -1);

        // Start recursion from the first job
        return maximumProfit(0);
    }

    // Recursive DP function to calculate maximum profit from index i onwards
    public int maximumProfit(int i) {

        // Base case: if we have processed all jobs
        if (i >= n) {
            return 0;
        }

        // If already computed, return stored result
        if (dp[i] != -1) {
            return dp[i];
        }

        // Option 1: Skip the current job
        int notTake = maximumProfit(i + 1);

        // Find the next job index whose start time >= current job's end time
        int nextidx = binarySearch(job[i][1]);

        // Option 2: Take the current job
        // Add its profit and move to the next compatible job
        int take = job[i][2] + maximumProfit(nextidx);

        // Store and return the maximum of both choices
        return dp[i] = Math.max(take, notTake);
    }

    // Binary search to find the first job with start time >= target end time
    public int binarySearch(int target) {

        int low = 0;
        int high = n - 1;

        // Default answer if no valid job is found
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If mid job can be scheduled after target time
            if (job[mid][0] >= target) {
                ans = mid;      // Possible answer
                high = mid - 1; // Try to find an earlier valid job
            } else {
                low = mid + 1;  // Search in the right half
            }
        }

        return ans;
    }
}
