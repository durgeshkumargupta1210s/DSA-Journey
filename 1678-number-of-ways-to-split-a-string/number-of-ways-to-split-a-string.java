class Solution {
    public int numWays(String s) {
        final int MOD = 1_000_000_007;
        int n = s.length();
        
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }
        if (totalOnes % 3 != 0) {
            return 0;
        }
        if (totalOnes == 0) {
            long ways = (long)(n - 1) * (n - 2) / 2;
            return (int)(ways % MOD);
        }
        int onesPerPart = totalOnes / 3;
        int count = 0;
        long firstCut = 0, secondCut = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            if (count == onesPerPart) {
                firstCut++;
            } else if (count == 2 * onesPerPart) {
                secondCut++;
            }
        }

        return (int)((firstCut * secondCut) % MOD);
    }
}
