class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;

        int maxLen = n - (numFriends - 1);
        String best = "";

        for (int i = 0; i < n; i++) {
            int end = Math.min(n, i + maxLen);
            String candidate = word.substring(i, end);
            if (candidate.compareTo(best) > 0) {
                best = candidate;
            }
        }

        return best;
    }
}
