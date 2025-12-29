class Solution {

    private int answer = Integer.MAX_VALUE;

    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        boolean[] used = new boolean[n];
        backtrack(strength, k, used, 1, 0, 0);
        return answer;
    }

    private void backtrack(List<Integer> strength, int k,
                           boolean[] used,
                           int factor,      // current sword factor x
                           int timeSoFar,   // accumulated time
                           int broken) {    // number of locks broken

        // Base case: all locks are broken
        if (broken == strength.size()) {
            answer = Math.min(answer, timeSoFar);
            return;
        }

        // Try breaking each unused lock next
        for (int i = 0; i < strength.size(); i++) {
            if (!used[i]) {
                used[i] = true;

                int s = strength.get(i);

                // Time needed = ceil(s / factor)
                int timeNeeded = (s + factor - 1) / factor;

                backtrack(
                    strength,
                    k,
                    used,
                    factor + k,               // factor increases after breaking
                    timeSoFar + timeNeeded,   // add time
                    broken + 1
                );

                used[i] = false; // backtrack
            }
        }
    }
}
