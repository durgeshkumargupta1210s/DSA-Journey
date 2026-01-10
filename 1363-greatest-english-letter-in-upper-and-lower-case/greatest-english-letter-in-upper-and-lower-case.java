class Solution {
    public String greatestLetter(String s) {

        // Tracks presence of lowercase letters
        boolean[] lower = new boolean[26];

        // Tracks presence of uppercase letters
        boolean[] upper = new boolean[26];

        // Scan the string once
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A'] = true;
            }
        }

        // Find the greatest letter that appears in both cases
        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                return String.valueOf((char) ('A' + i));
            }
        }

        // No valid letter found
        return "";
    }
}
