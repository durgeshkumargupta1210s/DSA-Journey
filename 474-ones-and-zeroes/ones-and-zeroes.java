import java.util.*;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] = max number of strings using i zeros and j ones
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0, ones = 0;

            // Count zeros and ones in the string
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            // Update dp in reverse order (to avoid reusing same string)
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
