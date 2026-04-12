class Solution {
    public boolean isBipartite(int[][] graph) {
        
        // Number of nodes in graph
        int n = graph.length;

        // Convert given graph (array format) into adjacency list
        // This helps in easier traversal
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        // Building undirected graph
        // NOTE: Given graph is already undirected in LeetCode,
        // but here we are explicitly adding both directions
        for(int i = 0; i < n; i++){
            for(int ele : graph[i]){
                list.get(i).add(ele);      // edge i -> ele
                list.get(ele).add(i);      // edge ele -> i
            }
        }

        // Color array:
        // -1 -> not colored
        //  0 -> color A
        //  1 -> color B
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        // Traverse all components (important for disconnected graph)
        for(int i = 0; i < n; i++){

            // If node is not colored, start BFS from it
            if(color[i] == -1){

                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                // Assign initial color
                color[i] = 0;

                // BFS traversal
                while(!q.isEmpty()){
                    int rv = q.poll(); // remove vertex

                    // Traverse all neighbors
                    for(int nbrs : list.get(rv)){

                        // Case 1: If neighbor has same color → NOT bipartite
                        if(color[rv] == color[nbrs]){
                            return false;
                        }

                        // Case 2: If neighbor is not colored → assign opposite color
                        else if(color[nbrs] == -1){
                            color[nbrs] = 1 - color[rv]; // alternate color
                            q.add(nbrs);
                        }
                    }
                }
            }
        }

        // If no conflict found, graph is bipartite
        return true; 
    }
}