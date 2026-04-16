class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        // Step 1: Sort intervals based on start time
        // If start times are equal, sort by end time
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Step 2: Initialize 'prev' as the first interval
        int[] prev = intervals[0];

        // This will store the number of intervals we need to remove
        int count = 0;

        // Step 3: Traverse through remaining intervals
        for (int i = 1; i < n; i++) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int prevStart = prev[0];
            int prevEnd = prev[1];

            // Step 4: Check if current interval overlaps with previous
            if (currStart < prevEnd) {

                // Overlap found → we need to remove one interval
                count++;

                // Greedy choice:
                // Keep the interval with smaller end time
                // because it leaves more space for future intervals
                if (currEnd < prevEnd) {
                    prev = intervals[i];
                }

                // else → keep prev as it is (it has smaller end)

            } else {
                // No overlap → move forward
                prev = intervals[i];
            }
        }

        // Step 5: Return total intervals removed
        return count;
    }
}