class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        // Queue to simulate people standing in line (stores their index)
        Queue<Integer> q = new LinkedList<>();

        // Add all people (0 to n-1) into the queue initially
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        // Variable to count total time (each ticket purchase = 1 second)
        int ans = 0;

        // Keep processing until person k finishes buying all tickets
        while (true) {

            // Remove the front person from the queue
            int rv = q.poll();

            // If this person still needs tickets
            if (tickets[rv] > 0) {

                // They buy one ticket (takes 1 second)
                tickets[rv]--;

                // Increase time counter
                ans++;
            }

            // If the person still needs more tickets,
            // they go back to the end of the queue
            if (tickets[rv] != 0) {
                q.add(rv);
            }

            // If this person has finished buying tickets
            // AND this person is k, return the total time
            if (tickets[rv] == 0 && rv == k) {
                return ans;
            }
        }
    }
}
