class Solution {

    // Graph representation using adjacency list:
    // Each node maps to a list of its neighboring nodes.
    Map<Integer, List<Integer>> graph;

    /*
     * Function to count "special nodes" in the graph.
     *
     * A node is called special if the distances from x, y, z form
     * a Pythagorean triple:
     *
     * d1² + d2² = d3²
     *
     * Parameters:
     * n     -> number of nodes
     * edges -> undirected edges of the graph
     * x,y,z -> three source nodes
     */
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {

        // Step 1: Build the graph using adjacency list
        graph = new HashMap<>();

        // Initialize adjacency list for every node
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        // Add edges in both directions since graph is undirected
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: Compute shortest distance from x, y, and z to every node
        int[] distX = bfs(n, x);
        int[] distY = bfs(n, y);
        int[] distZ = bfs(n, z);

        // Variable to store count of special nodes
        int count = 0;

        // Step 3: Check every node if it satisfies the Pythagorean condition
        for(int i = 0; i < n; i++){

            // Distances of node i from x, y, z
            int a = distX[i];
            int b = distY[i];
            int c = distZ[i];

            // If node is unreachable from any of x, y, or z, skip it
            if(a == -1 || b == -1 || c == -1) continue;

            // Store distances in array and sort them
            // arr[0] = smallest, arr[1] = middle, arr[2] = largest
            int[] arr = {a, b, c};
            Arrays.sort(arr);

            // Step 4: Check if the distances form a right triangle:
            // arr[0]^2 + arr[1]^2 == arr[2]^2
            if(arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2]){
                count++; // Node is special
            }
        }

        // Return total count of special nodes
        return count;
    }

    /*
     * BFS function to compute shortest distance from a given start node.
     *
     * Returns:
     * dist[i] = shortest distance from start to node i
     * dist[i] = -1 if node i is unreachable
     */
    public int[] bfs(int n, int start){

        // Distance array initialized with -1 (unvisited)
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        // Distance to start node is always 0
        dist[start] = 0;

        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        // Standard BFS loop
        while(!q.isEmpty()){

            // Get current node from queue
            int node = q.poll();

            // Visit all neighbors of current node
            for(int nbr : graph.get(node)){

                // If neighbor is not visited yet
                if(dist[nbr] == -1){

                    // Update distance of neighbor
                    dist[nbr] = dist[node] + 1;

                    // Add neighbor to queue for further traversal
                    q.add(nbr);
                }
            }
        }

        // Return computed shortest distances
        return dist;
    }
}
