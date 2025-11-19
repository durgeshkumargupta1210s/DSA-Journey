class Solution {
    public int longestCycle(int[] edges) {
        return longestCycles(edges);
    }
    public  int longestCycles(int [] edges) {

        // indegree array: counts incoming edges for each node
        int [] in = new int[edges.length];

        // Step 1: Build indegree for each node
        for(int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {      // ignore invalid edges
                in[edges[i]]++;
            }
        }

        // Step 2: Add nodes with indegree 0 to queue (they can't be in cycles)
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < in.length; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }

        // visited array to mark nodes removed during trimming
        boolean [] visited = new boolean[edges.length];

        // Step 3: Remove all non-cycle nodes using Kahn's Algorithm logic
        while(!q.isEmpty()) {
            int e = q.poll();
            visited[e] = true; // this node cannot be part of a cycle
            
            if (edges[e] != -1) {  // valid outgoing edge
                in[edges[e]]--;    // remove its inorder contribution

                if(in[edges[e]] == 0) {
                    q.add(edges[e]); // this node now becomes non-cyclic too
                }
            }
        }

        // Step 4: Explore remaining unvisited nodes to count cycle length
        int ans = -1;

        for(int i = 0; i < visited.length; i++) {

            // If not visited, then it belongs to a cycle
            if(!visited[i]) {
                int c = 1;            // cycle length counter
                visited[i] = true;    // mark starting point

                int nbrs = edges[i];  // next node in directed graph

                // continue until we reach starting point again
                while(nbrs != i) {
                    c++;
                    visited[nbrs] = true;
                    nbrs = edges[nbrs];
                }

                ans = Math.max(ans, c); // update maximum cycle length
            }
        }

        return ans;
    }
}