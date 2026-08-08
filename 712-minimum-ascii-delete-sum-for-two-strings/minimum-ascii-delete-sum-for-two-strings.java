class Solution {
    static int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {

        dp = new int[s1.length()][s2.length()];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solve(s1, s2, 0, 0);
    }

    public static int solve(String word1, String word2, int i, int j) {

        if (i == word1.length()) {

            int sum = 0;

            for (int x = j; x < word2.length(); x++) {
                sum += word2.charAt(x);
            }

            return sum;
        }

        
        if (j == word2.length()) {

            int sum = 0;

            for (int x = i; x < word1.length(); x++) {
                sum += word1.charAt(x);
            }

            return sum;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans;

        if (word1.charAt(i) == word2.charAt(j)) {

            ans = solve(word1, word2, i + 1, j + 1);

        } else {

            int del1 = word1.charAt(i)
                    + solve(word1, word2, i + 1, j);

            int del2 = word2.charAt(j)
                    + solve(word1, word2, i, j + 1);

            ans = Math.min(del1, del2);
        }

        return dp[i][j] = ans;
    }
}