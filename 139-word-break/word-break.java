import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return breakWord(s, dict, 0, dp);
    }

    public boolean breakWord(String s, Set<String> dict, int idx, int[] dp) {

        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != -1) {
            return dp[idx] == 1;
        }

        for (int end = idx + 1; end <= s.length(); end++) {
            String word = s.substring(idx, end);

            if (dict.contains(word) && breakWord(s, dict, end, dp)) {
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0;
        return false;
    }
}