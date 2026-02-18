import java.util.*;

public class Solution {

    public static int maximumInvitations(int[] favorite) {

        int n = favorite.length;

        // Step 1: Calculate indegree of each node
        // indegree[i] = number of people who like person i
        int[] indegree = new int[n];
        for (int f : favorite)
            indegree[f]++;

        // Step 2: Topological sort to remove non-cycle nodes
        // and calculate longest chain leading into each node
        Queue<Integer> queue = new LinkedList<>();

        // depth[i] = longest chain length ending at person i
        int[] depth = new int[n];

        // Add nodes with indegree 0 (not part of any cycle)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        // Process nodes using topological sort (BFS)
        while (!queue.isEmpty()) {

            int node = queue.poll();

            // Person liked by current node
            int next = favorite[node];

            // Update maximum chain length reaching next node
            depth[next] = Math.max(depth[next], depth[node] + 1);

            // Reduce indegree since node is removed
            indegree[next]--;

            // If indegree becomes 0, add to queue
            if (indegree[next] == 0)
                queue.add(next);
        }

        // Step 3: Detect cycles
        boolean[] visited = new boolean[n];

        // maxCycle = length of largest cycle of size > 2
        int maxCycle = 0;

        // pairChains = sum of all mutual pairs (cycle length 2)
        // plus their incoming chains
        int pairChains = 0;

        for (int i = 0; i < n; i++) {

            // Skip nodes not part of cycle
            if (indegree[i] == 0)
                continue;

            int cycleLength = 0;
            int curr = i;

            // Traverse cycle
            while (!visited[curr]) {
                visited[curr] = true;
                curr = favorite[curr];
                cycleLength++;
            }

            // Case 1: Cycle length == 2 (mutual favorite pair)
            if (cycleLength == 2) {

                int a = i;
                int b = favorite[i];

                // Add pair + incoming chains
                pairChains += 2 + depth[a] + depth[b];

            }
            // Case 2: Cycle length > 2
            else {

                // Take maximum cycle length
                maxCycle = Math.max(maxCycle, cycleLength);
            }
        }

        // Final answer is maximum of:
        // 1. Largest cycle (>2)
        // 2. Sum of all mutual pair chains
        return Math.max(maxCycle, pairChains);
    }

    public static void main(String[] args) {

        int[] favorite = {2,2,1,2};

        System.out.println(maximumInvitations(favorite)); // Output: 3
    }
}
