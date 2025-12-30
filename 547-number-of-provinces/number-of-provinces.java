import java.util.*;

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        // Check each city
        for (int i = 0; i < n; i++) {

            // If city is not visited, it starts a new province
            if (!visited[i]) {
                provinces++;
                BFS(i, isConnected, visited);
            }
        }

        return provinces;
    }

    // BFS in your exact format
    public void BFS(int src, int[][] isConnected, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        // 0. Add source
        q.add(src);

        while (!q.isEmpty()) {

            // 1. Remove
            int r = q.poll();

            // 2. Ignore if already visited
            if (visited[r]) {
                continue;
            }

            // 3. Mark visited
            visited[r] = true;

            // 4. Self work
            // (No specific work needed for province counting)

            // 5. Add unvisited neighbors
            for (int nbr = 0; nbr < isConnected.length; nbr++) {
                if (isConnected[r][nbr] == 1 && !visited[nbr]) {
                    q.add(nbr);
                }
            }
        }
    }
}
