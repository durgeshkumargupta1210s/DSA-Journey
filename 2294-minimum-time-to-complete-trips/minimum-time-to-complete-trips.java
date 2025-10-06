class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // Find the minimum time among all buses
        long minTime = Long.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        // Binary search boundaries
        long low = 1;                     // minimum possible time
       long high = minTime * (long) totalTrips;  // maximum possible time
        // long high =100000;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long calculatedTrips = calculateTrip(time, mid);

            if (calculatedTrips >= totalTrips) {
                // Can complete enough trips → try smaller time
                ans = mid;
                high = mid - 1;
            } else {
                // Not enough trips → need more time
                low = mid + 1;
            }
        }

        return ans;
    }

    // Helper function to calculate total trips completed in 'time'
    public long calculateTrip(int[] time, long t) {
        long sum = 0;
        for (int i = 0; i < time.length; i++) {
            sum += t / time[i];
        }
        return sum;
    }
}
