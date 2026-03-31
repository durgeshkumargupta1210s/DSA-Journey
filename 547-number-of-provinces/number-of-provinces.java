class Solution {

    // Function to count number of provinces (connected components)
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // Visited set to track explored cities
        Set<Integer> visited = new HashSet<>();

        int count = 0;  // number of provinces

        // Traverse all cities
        for(int i = 0; i < n; i++){

            // If already visited, skip
            if(visited.contains(i)){
                continue;
            }

            // New province found
            count++;

            // Start BFS from this city
            q.add(i);

            while(!q.isEmpty()){

                int rv = q.poll();   // remove current city

                // If already visited, skip processing
                if(visited.contains(rv)){
                    continue;
                }

                // Mark as visited
                visited.add(rv);

                // Traverse all neighbors (adjacency matrix row)
                for(int nbr = 0; nbr < n; nbr++){

                    // If connected and not visited, add to queue
                    if(isConnected[rv][nbr] == 1 && !visited.contains(nbr)){
                        q.add(nbr);
                    }
                }
            }
        }

        return count;
    }
}