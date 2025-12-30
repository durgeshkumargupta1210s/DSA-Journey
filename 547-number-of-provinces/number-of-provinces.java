class Solution {

    // Main function to count the number of provinces (connected components)
    public int findCircleNum(int[][] isConnected) {

        // Number of cities (nodes)
        int row = isConnected.length;

        // This will store the final count of provinces
        int ans = 0;

        // Visited array to track which cities have already been explored
        boolean[] visited = new boolean[row];

        // Iterate over each city
        for (int i = 0; i < row; i++) {

            // If the city is not visited, it starts a new province
            if (!visited[i]) {
                ans++;                      // New province found
                dfs(isConnected, visited, i); // Explore all connected cities
            }
        }

        return ans;
    }

    // Depth-First Search to visit all cities connected to the current city
    public void dfs(int[][] grid, boolean[] visited, int node) {

        // Mark the current city as visited
        visited[node] = true;

        // Explore all possible connections from this city
        for (int i = 0; i < grid.length; i++) {

            // If city i is connected and not yet visited
            if (!visited[i] && grid[node][i] == 1) {
                dfs(grid, visited, i); // Recursively visit connected city
            }
        }
    }
}
