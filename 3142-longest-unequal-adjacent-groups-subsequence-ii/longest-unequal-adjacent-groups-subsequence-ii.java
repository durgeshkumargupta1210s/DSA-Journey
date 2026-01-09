import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {

        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int endIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (groups[i] != groups[j]
                        && words[i].length() == words[j].length()
                        && hammingDistance(words[i], words[j]) == 1) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIdx = i;
            }
        }

        // Reconstruct answer
        LinkedList<String> result = new LinkedList<>();
        while (endIdx != -1) {
            result.addFirst(words[endIdx]);
            endIdx = prev[endIdx];
        }

        return result;
    }

    private int hammingDistance(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return diff;
        }
        return diff;
    }
}
