class Solution {

    // Returns the total number of seats booked for each flight
    public int[] corpFlightBookings(int[][] bookings, int n) {

        // Difference array to efficiently apply range seat additions
        // diff[i] represents the change in seats starting at index i
        int[] diff = new int[n + 1];

        // Process each booking entry
        // Each booking is of the form [first, last, seats]
        for (int[] arr : bookings) {

            // Convert flight numbers from 1-based to 0-based indexing
            int first = arr[0] - 1;
            int last  = arr[1] - 1;
            int seats = arr[2];

            // Begin adding 'seats' from the 'first' flight
            diff[first] += seats;

            // Stop adding 'seats' after the 'last' flight
            // (only if the index is within bounds)
            if (last + 1 < n) {
                diff[last + 1] -= seats;
            }
        }

        // Result array to store total seats booked for each flight
        int[] ans = new int[n];

        // Prefix sum variable to accumulate seat changes
        int sum = 0;

        // Build the final seat count for each flight
        for (int i = 0; i < n; i++) {

            // Accumulate the difference array
            sum += diff[i];

            // Total seats booked for flight (i + 1)
            ans[i] = sum;
        }

        // Return the final bookings array
        return ans;
    }
}
