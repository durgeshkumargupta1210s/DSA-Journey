class Solution {

    // Adjacency list to store the graph
    // list.get(i) will contain all neighbors of node i
    List<List<Integer>> list;

    public long countPairs(int n, int[][] edges) {

        // Step 1: Initialize adjacency list for n nodes
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // Step 2: Build undirected graph
        // For each edge u-v, add v to u's list and u to v's list
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        // Step 3: Visited array to track visited nodes during DFS
        boolean[] visited = new boolean[n];

        // result will store total unreachable pairs
        long result = 0;

        // remaining represents number of nodes not yet processed
        long remaining = n;

        // Step 4: Traverse all nodes
        for (int i = 0; i < n; i++) {

            // If node is not visited, it means new connected component found
            if (!visited[i]) {

                // Find size of this connected component using DFS
                long size = dfs(i, visited);

                /*
                 Formula explanation:
                 size = nodes in current component
                 remaining = nodes not yet processed

                 size * (remaining - size)
                 gives number of unreachable pairs between:
                 current component and other components
                */
                result += size * (remaining - size);

                // Remove this component from remaining nodes
                remaining -= size;
            }
        }

        // Return total unreachable pairs
        return result;
    }

    // DFS function to calculate size of connected component
    public long dfs(int node, boolean[] visited) {

        // Mark current node as visited
        visited[node] = true;

        // Count current node
        long count = 1;

        // Visit all neighbors
        for (int nbrs : list.get(node)) {

            // If neighbor not visited, explore it recursively
            if (!visited[nbrs]) {
                count += dfs(nbrs, visited);
            }
        }

        // Return total size of this connected component
        return count;
    }
}
