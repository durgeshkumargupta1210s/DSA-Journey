class Solution {

    List<List<Integer>> graph;
    int[] bobTime;
    int[] amount;
    int n;
    int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.amount = amount;
        n = amount.length;

        // Build graph
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Step 1: Compute Bob arrival times
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        dfsBob(bob, -1, 0);

        // Step 2: Alice DFS
        dfsAlice(0, -1, 0, 0);

        return ans;
    }

    // DFS to record Bob's time (only path to root matters)
    private boolean dfsBob(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }

        for (int nbr : graph.get(node)) {
            if (nbr == parent) continue;
            if (dfsBob(nbr, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    // DFS for Alice
    private void dfsAlice(int node, int parent, int time, int profit) {

        // Profit calculation
        if (time < bobTime[node]) {
            profit += amount[node];
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2;
        }

        boolean isLeaf = true;

        for (int nbr : graph.get(node)) {
            if (nbr == parent) continue;
            isLeaf = false;
            dfsAlice(nbr, node, time + 1, profit);
        }

        // Alice stops only at leaf nodes
        if (isLeaf) {
            ans = Math.max(ans, profit);
        }
    }
}
