import java.util.*;

class Solution {
    public int findTheWinner(int n, int k) {

        Queue<Integer> q = new LinkedList<>();

        // Step 1: Add all players to the queue
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // Step 2: Eliminate players until one remains
        while (q.size() > 1) {

            // Move k-1 players to the back
            for (int i = 1; i < k; i++) {
                q.add(q.poll());
            }

            // Remove the k-th player
            q.poll();
        }

        // Step 3: Return the winner
        return q.peek();
    }
}
