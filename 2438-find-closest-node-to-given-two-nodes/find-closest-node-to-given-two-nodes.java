class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        // Distance arrays
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        // Initialize distances with -1 (unreachable)
        for (int i = 0; i < n; i++) {
            dist1[i] = -1;
            dist2[i] = -1;
        }

        // Compute distances from node1
        fillDistance(edges, node1, dist1);

        // Compute distances from node2
        fillDistance(edges, node2, dist2);

        int answer = -1;
        int minMaxDistance = Integer.MAX_VALUE;

        // Find node minimizing max(dist1[i], dist2[i])
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currentMax = Math.max(dist1[i], dist2[i]);
                if (currentMax < minMaxDistance) {
                    minMaxDistance = currentMax;
                    answer = i;
                }
            }
        }

        return answer;
    }

    // Helper method to compute distance from a start node
    private void fillDistance(int[] edges, int start, int[] dist) {
        int current = start;
        int distance = 0;

        while (current != -1 && dist[current] == -1) {
            dist[current] = distance;
            distance++;
            current = edges[current];
        }
    }
}
