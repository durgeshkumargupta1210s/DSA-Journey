class Solution {
    public int minCost(String colors, int[] neededTime) {
        return min_cost(colors, neededTime);
    }

    private static int min_cost(String c, int[] n) {
        int sum = 0; // Total cost of removing balloons
        int maxTime = 0; // Maximum time in the current group

        for (int i = 0; i < c.length(); i++) {
            // If it's the start of a new group or the same color as the previous balloon
            if (i > 0 && c.charAt(i) != c.charAt(i - 1)) {
                maxTime = 0; // Reset maxTime for the new group
            }

            // Add the time to the total sum
            sum += Math.min(maxTime, n[i]);

            // Update the maxTime for the current group
            maxTime = Math.max(maxTime, n[i]);
        }

        return sum;
    }
}