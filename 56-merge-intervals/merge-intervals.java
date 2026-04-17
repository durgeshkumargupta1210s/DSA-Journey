class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // List to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 2: Initialize with the first interval
        int[] prev = intervals[0];

        // Step 3: Traverse remaining intervals
        for (int i = 1; i < n; i++) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            // Step 4: Check overlap
            if (currStart <= prev[1]) {

                // Overlapping intervals → merge them
                // Update end of previous interval
                prev[1] = Math.max(prev[1], currEnd);

            } else {

                // No overlap → store previous interval
                result.add(prev);

                // Move to next interval
                prev = intervals[i];
            }
        }

        // Step 5: Add the last interval
        result.add(prev);

        // Convert list to 2D array
        return result.toArray(new int[result.size()][]);
    }
}