class Solution {

    // Adjacency list representation of the graph
    // key   -> person
    // value -> list of people this person dislikes
    Map<Integer, List<Integer>> map;

    public boolean possibleBipartition(int n, int[][] dislikes) {

        // -------------------------------
        // STEP 1: Build the graph
        // -------------------------------
        map = new HashMap<>();

        // Initialize adjacency list for each person (1 to n)
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Populate the adjacency list using dislikes array
        // Since dislikes are mutual, this is an undirected graph
        for (int[] a : dislikes) {
            int u = a[0];
            int v = a[1];

            map.get(u).add(v);
            map.get(v).add(u);
        }

        // -------------------------------
        // STEP 2: Coloring array
        // -------------------------------
        // arr[i] = -1  -> not colored yet
        // arr[i] = 1   -> group 1
        // arr[i] = 2   -> group 2
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);

        // -------------------------------
        // STEP 3: BFS for each component
        // -------------------------------
        // Graph may be disconnected, so we must check every node
        for (int i = 1; i <= n; i++) {

            // If already colored, skip (already processed)
            if (arr[i] != -1) {
                continue;
            }

            // Start BFS from this unvisited node
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            // Assign first group to the starting node
            arr[i] = 1;

            while (!q.isEmpty()) {

                int current = q.poll();

                // Traverse all neighbors
                for (int nbrs : map.get(current)) {

                    //  If neighbor has same color → not bipartite
                    if (arr[current] == arr[nbrs]) {
                        return false;
                    }

                    // If neighbor is uncolored, assign opposite color
                    if (arr[nbrs] == -1) {
                        // If current is 1 → neighbor = 2
                        // If current is 2 → neighbor = 1
                        arr[nbrs] = 3 - arr[current];
                        q.add(nbrs);
                    }
                }
            }
        }

        // If no conflicts found, bipartition is possible
        return true;
    }
}
