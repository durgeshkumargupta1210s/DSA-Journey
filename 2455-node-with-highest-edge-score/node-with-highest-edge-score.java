class Solution {
    public int edgeScore(int[] edges) {

        int n = edges.length;
        long[] score = new long[n];

        // Step 1: Calculate edge scores
        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
        }

        // Step 2: Find node with maximum score
        long maxScore = -1;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                result = i;
            }
        }

        return result;
    }
}
