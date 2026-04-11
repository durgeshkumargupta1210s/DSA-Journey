class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency list to represent the graph
        // list.get(u) -> contains all courses dependent on course u
        List<List<Integer>> list = new ArrayList<>();

        // Initialize adjacency list for all courses
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        // indegree[i] = number of prerequisites required for course i
        int[] indegree = new int[numCourses];

        // Build the graph
        // prerequisites[i] = [a, b] means: to take course 'a', you must first take 'b'
        for(int[] pre : prerequisites){
            int a = pre[0]; // course to take
            int b = pre[1]; // prerequisite course

            // Directed edge: b → a
            list.get(b).add(a);

            // Increase indegree of 'a' (since it depends on 'b')
            indegree[a]++;
        }

        // Queue for BFS (Kahn’s Algorithm - Topological Sort)
        Queue<Integer> q = new LinkedList<>();

        // Add all courses with no prerequisites (indegree = 0)
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        // Count of courses we can complete
        int count = 0;

        // Process nodes using BFS
        while(!q.isEmpty()){
            int rv = q.poll(); // remove course with no remaining prerequisites
            count++;

            // Visit all dependent courses (neighbors)
            for(int nbrs : list.get(rv)){
                indegree[nbrs]--; // remove dependency

                // If no prerequisites left, add to queue
                if(indegree[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }

        // If we were able to process all courses → no cycle exists
        // Otherwise, cycle is present → cannot finish all courses
        return count == numCourses;
    }
}