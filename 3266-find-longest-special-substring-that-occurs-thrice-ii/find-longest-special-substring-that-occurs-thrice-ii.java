class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;
        int[][] cnt = new int[26][n + 1];
        int i = 0;
        while (i < n) {
            int j = i;
            char ch = s.charAt(i);

            while (j < n && s.charAt(j) == ch) {
                j++;
            }
            int len = j - i;
            int c = ch - 'a';
            for (int L = 1; L <= len; L++) {
                cnt[c][L] += (len - L + 1);
            }
            i = j;
        }
        for (int c = 0; c < 26; c++) {
            for (int L = 1; L <= n; L++) {
                if (cnt[c][L] >= 3) {
                    ans = Math.max(ans, L);
                }
            }
        }

        return ans;
    }
}