class Solution {
    public String minimizeStringValue(String s) {
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];
        List<Character> replacements = new ArrayList<>();

        // Count frequencies of existing letters (ignore '?')
        for (char c : s.toCharArray()) {
            if (c != '?') {
                count[c - 'a']++;
            }
        }

        // For each '?', pick the lexicographically smallest letter
        // with the minimal frequency
        for (char c : s.toCharArray()) {
            if (c == '?') {
                int minFreq = Integer.MAX_VALUE;
                int chosen = 0;
                for (int i = 0; i < 26; i++) {
                    if (count[i] < minFreq) {
                        minFreq = count[i];
                        chosen = i;
                    }
                }
                // Choose that letter and increment its frequency
                replacements.add((char) ('a' + chosen));
                count[chosen]++;
            }
        }

        // Sort chosen replacement letters to ensure lexicographically
        // smallest string among all minimal-value strings
        Collections.sort(replacements);

        // Build final string
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == '?') {
                result.append(replacements.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
