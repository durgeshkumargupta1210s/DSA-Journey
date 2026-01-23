class Solution {
    public boolean isItPossible(String word1, String word2) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequencies
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Count distinct characters
        int distinct1 = 0, distinct2 = 0;

        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) distinct1++;
            if (freq2[i] > 0) distinct2++;
        }

        // Try every possible swap (c1 from word1, c2 from word2)
        for (int c1 = 0; c1 < 26; c1++) {
            if (freq1[c1] == 0) continue;

            for (int c2 = 0; c2 < 26; c2++) {
                if (freq2[c2] == 0) continue;

                // If swapping same character, distinct count unchanged
                if (c1 == c2) {
                    if (distinct1 == distinct2) return true;
                    continue;
                }

                int newDistinct1 = distinct1;
                int newDistinct2 = distinct2;

                // --- word1 loses c1 ---
                if (freq1[c1] == 1) newDistinct1--;

                // --- word1 gains c2 ---
                if (freq1[c2] == 0) newDistinct1++;

                // --- word2 loses c2 ---
                if (freq2[c2] == 1) newDistinct2--;

                // --- word2 gains c1 ---
                if (freq2[c1] == 0) newDistinct2++;

                // Check if equal after swap
                if (newDistinct1 == newDistinct2) return true;
            }
        }

        return false;
    }
}
