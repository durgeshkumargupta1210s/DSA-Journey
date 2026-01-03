class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] d : dislikes) {
            int u = d[0];
            int v = d[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: Color array
        int[] color = new int[n + 1]; // 0 = uncolored, 1 = group A, -1 = group B

        // Step 3: BFS for each component
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int nbr : graph.get(curr)) {
                    // If same color → conflict
                    if (color[nbr] == color[curr]) {
                        return false;
                    }

                    // If uncolored → color opposite
                    if (color[nbr] == 0) {
                        color[nbr] = -color[curr];
                        q.offer(nbr);
                    }
                }
            }
        }

        return true;
    }
}
