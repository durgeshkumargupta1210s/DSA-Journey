import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];  // Stores max frequency required for each character
        
        // Build the frequency requirement from words2
        for (String b : words2) {
            int[] freq = count(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freqA = count(a);
            if (isUniversal(freqA, maxFreq)) {
                result.add(a);
            }
        }
        return result;
    }
    
    // Helper: count frequency of characters in a word
    private int[] count(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    
    // Helper: check if word satisfies the max frequency requirement
    private boolean isUniversal(int[] wordFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreq[i]) return false;
        }
        return true;
    }
}
