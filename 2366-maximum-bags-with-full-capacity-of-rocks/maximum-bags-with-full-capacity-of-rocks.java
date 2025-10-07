import java.util.*;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] need = new int[n];

        // Calculate how many rocks are needed for each bag
        for (int i = 0; i < n; i++) {
            need[i] = capacity[i] - rocks[i];
        }

        // Sort to fill bags needing fewer rocks first
        Arrays.sort(need);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (need[i] == 0) {
                count++; // already full
            } else if (additionalRocks >= need[i]) {
                additionalRocks -= need[i];
                count++;
            } else {
                break; // can't fill this bag or any further because need[i] is sorted ascending
            }
        }

        return count;
    }
}
