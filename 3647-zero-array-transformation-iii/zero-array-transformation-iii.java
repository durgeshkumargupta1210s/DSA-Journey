import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // ---------- STEP 1: FEASIBILITY CHECK ----------
        int[] cover = new int[n + 1];
        for (int[] q : queries) {
            cover[q[0]]++;
            if (q[1] + 1 < n) cover[q[1] + 1]--;
        }

        int running = 0;
        for (int i = 0; i < n; i++) {
            running += cover[i];
            if (running < nums[i]) {
                return -1;
            }
        }

        // ---------- STEP 2: GREEDY SELECTION ----------
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int[] diff = new int[n + 1];
        int qIdx = 0;
        int used = 0;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];

            while (qIdx < m && queries[qIdx][0] == i) {
                maxHeap.offer(queries[qIdx][1]);
                qIdx++;
            }

            while (curr < nums[i]) {
                int end = maxHeap.poll();
                used++;
                curr++;

                if (end + 1 < n) {
                    diff[end + 1]--;
                }
            }
        }

        return m - used;
    }
}
