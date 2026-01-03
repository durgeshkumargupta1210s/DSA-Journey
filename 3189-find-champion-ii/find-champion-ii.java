class Solution {
    public int findChampion(int n, int[][] edges) {

        int[] indegree = new int[n];

        // Step 1: Calculate indegrees
        for (int[] edge : edges) {
            int weaker = edge[1];
            indegree[weaker]++;
        }

        // Step 2: Find unique node with indegree 0
        int champion = -1;
        int countZero = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champion = i;
                countZero++;
            }
        }

        // Step 3: Validate uniqueness
        return countZero == 1 ? champion : -1;
    }
}
