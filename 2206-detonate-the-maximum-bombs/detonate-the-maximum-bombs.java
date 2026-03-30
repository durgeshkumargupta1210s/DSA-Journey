class Solution {

    // Adjacency list to represent directed graph
    // list[i] → all bombs that can be detonated by bomb i
    static List<List<Integer>> list;

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;

        // Step 1: Initialize adjacency list
        list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        // Step 2: Build graph
        // If bomb i can trigger bomb j → add directed edge i → j
        for(int i = 0; i < n; i++){

            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r  = bombs[i][2];

            for(int j = 0; j < n; j++){
                if(i == j) continue; // skip same bomb

                int x2 = bombs[j][0];
                int y2 = bombs[j][1];

                // Calculate squared distance to avoid sqrt (optimization)
                long dist = (long)(x2 - x1) * (x2 - x1) + 
                            (long)(y2 - y1) * (y2 - y1);

                // If bomb j lies within radius of bomb i
                if(dist <= (long)r * r){
                    list.get(i).add(j); // directed edge
                }
            }
        }

        int max = 0;

        // Step 3: Try BFS from every bomb (multi-source simulation)
        // Each bomb acts as a starting point
        for(int i = 0; i < n; i++){
            max = Math.max(max, bfs(i));
        }

        return max;
    }

    // BFS to count how many bombs can be detonated starting from 'node'
    public static int bfs(int node){

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize BFS
        q.add(node);
        visited.add(node);

        int count = 1; // starting bomb itself

        while(!q.isEmpty()){
            int rv = q.poll(); // remove current bomb

            // Traverse all bombs that current bomb can trigger
            for(int nbrs : list.get(rv)){
                if(!visited.contains(nbrs)){
                    visited.add(nbrs);  // mark visited
                    q.add(nbrs);        // push into queue
                    count++;            // increase detonation count
                }
            }
        }

        return count;
    }
}