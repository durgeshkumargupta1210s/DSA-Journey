class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        // Step 1: Create reverse graph
        // list.get(u) → nodes that point to u (reverse edges)
        List<List<Integer>> list = new ArrayList<>();

        int n = graph.length;

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        // indegree[i] → number of outgoing edges from node i in original graph
        // (i.e., how many nodes i points to)
        int[] indegree = new int[n];

        // Build reverse graph + indegree
        for(int i = 0; i < n; i++){

            for(int nbrs : graph[i]){
                // Reverse edge: nbr → i becomes i ← nbr
                list.get(nbrs).add(i);
            }

            // Outdegree of node i (treated as indegree in reverse logic)
            indegree[i] = graph[i].length;
        }

        // Step 2: Start with terminal nodes (nodes with no outgoing edges)
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        // List to store safe nodes
        List<Integer> li = new ArrayList<>();

        // Step 3: BFS (Kahn’s Algorithm on reverse graph)
        while(!q.isEmpty()){
            int rv = q.poll();
            li.add(rv); // this node is safe

            // Reduce dependency of nodes pointing to current node
            for(int nbrs : list.get(rv)){
                indegree[nbrs]--;

                // If no outgoing edges left → becomes safe
                if(indegree[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }

        // Step 4: Sort result as required by problem
        Collections.sort(li);

        return li;
    }
}