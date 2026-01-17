class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indeg = new int[n + 1];
        for (int[] r : relations) {
            int u = r[0], v = r[1];
            graph.get(u).add(v);
            indeg[v]++;
        }

        // dp[i] = minimum time to finish course i
        int[] dp = new int[n + 1];

        Queue<Integer> q = new ArrayDeque<>();

        // Initialize queue with courses having no prerequisites
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                dp[i] = time[i - 1];
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                dp[v] = Math.max(dp[v], dp[u] + time[v - 1]);

                indeg[v]--;
                if (indeg[v] == 0) {
                    q.add(v);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
