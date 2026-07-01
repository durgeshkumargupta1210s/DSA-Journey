class Solution {
    public int countValidWords(String sentence) {

        int count = 0;

        for (String word : sentence.split(" ")) {
            
            if (isValid(word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(String word) {

        if (word.length() == 0) {
            return false;
        }

        int hyphenCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int lastIdx = word.length() - 1;

            if (ch >= '0' && ch <= '9') {
                return false;
            }

            if (ch == '-') {
                hyphenCount++;

                if (hyphenCount > 1) {
                    return false;
                }

                if (i == 0 || i == lastIdx) {
                    return false;
                }

                char prev = word.charAt(i - 1);
                char next = word.charAt(i + 1);

                if (!(prev >= 'a' && prev <= 'z') || !(next >= 'a' && next <= 'z')) {
                    return false;
                }
            }

            if (ch == '!' || ch == '.' || ch == ',') {
                if (i != lastIdx) {
                    return false;
                }
            }
        }

        return true;
    }
}