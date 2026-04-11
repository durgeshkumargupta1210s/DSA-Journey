class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list: graph representation
        // list.get(u) → all courses that depend on course u
        List<List<Integer>> list = new ArrayList<>();

        // Initialize graph for all courses
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        // indegree[i] → number of prerequisites required for course i
        int[] indegree = new int[numCourses];

        // Build graph and indegree array
        // [a, b] means: b → a (b must be completed before a)
        for(int[] pre : prerequisites){
            int a = pre[0]; // course to take
            int b = pre[1]; // prerequisite

            list.get(b).add(a); // directed edge
            indegree[a]++;      // increase dependency count
        }

        // Queue for BFS (Topological Sort using Kahn’s Algorithm)
        Queue<Integer> q = new LinkedList<>();

        // Add all courses with no prerequisites
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        // List to store the topological order
        List<Integer> li = new ArrayList<>();

        // Process nodes in BFS manner
        while(!q.isEmpty()){
            int rv = q.poll();  // course with no remaining dependencies
            li.add(rv);         // add to result

            // Visit all dependent courses
            for(int nbrs : list.get(rv)){
                indegree[nbrs]--; // remove dependency

                // If no prerequisites left, push into queue
                if(indegree[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }

        // Prepare result array
        int[] result = new int[numCourses];

        // If we couldn't process all courses → cycle exists → return empty array
        if(li.size() != numCourses){
           return new int[0];// default empty (all zeros, but treated as empty)
        }

        // Copy topological order into result array
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }

        return result;
    }
}