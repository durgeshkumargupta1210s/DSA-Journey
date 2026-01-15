import java.util.*;

class Solution {

    // Trie Node definition
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    // Insert a word into the Trie
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
    }

    public int minValidStrings(String[] words, String target) {
        // Build Trie
        for (String word : words) {
            insert(word);
        }

        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n] = 0; // base case

        // DP from right to left
        for (int i = n - 1; i >= 0; i--) {
            TrieNode node = root;

            for (int j = i; j < n; j++) {
                int idx = target.charAt(j) - 'a';
                if (node.children[idx] == null) {
                    break; // no further prefix possible
                }

                node = node.children[idx];

                if (dp[j + 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}
