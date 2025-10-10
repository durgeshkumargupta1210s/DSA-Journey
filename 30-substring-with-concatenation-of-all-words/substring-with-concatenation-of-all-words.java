import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return list;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return list;

        // Step 1: Word frequency map
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }

        // Step 2: We check wordLen different starting positions to cover all alignments
        for (int i = 0; i < wordLen; i++) {
            int left = i; // start of current window
            int right = i;
            int matched = 0;
            Map<String, Integer> seen = new HashMap<>();

            // Step 3: Slide window in chunks of wordLen
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If it's a valid word, add to seen
                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    matched++;

                    // If this word appears more than required, shrink window from left
                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        matched--;
                        left += wordLen;
                    }

                    // If all words matched, record start index
                    if (matched == wordCount) {
                        list.add(left);
                    }

                } else {
                    // Reset window if word not found
                    seen.clear();
                    matched = 0;
                    left = right;
                }
            }
        }

        return list;
    }
}
