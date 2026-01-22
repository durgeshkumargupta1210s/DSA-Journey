class Solution {

    public int maximizeWin(int[] prizePositions, int k) {

        int n = prizePositions.length;

        // dp[i] = maximum prizes we can collect using
        // one segment in range [0 .. i]
        int[] dp = new int[n];

        int left = 0;   // left pointer of sliding window
        int ans = 0;    // stores final maximum result

        for (int right = 0; right < n; right++) {

            // Shrink window until its length is within k
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }

            // Number of prizes in current valid window
            int curr = right - left + 1;

            // Best single segment ending at or before right
            dp[right] = curr;
            if (right > 0) {
                dp[right] = Math.max(dp[right], dp[right - 1]);
            }

            /*
             Combine current segment with the best
             non-overlapping segment before it
            */
            int prev = (left > 0) ? dp[left - 1] : 0;

            // Update answer using two segments
            ans = Math.max(ans, curr + prev);
        }

        return ans;
    }
}
