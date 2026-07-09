class Solution {
    public int find(int[] arr, int x) {
        if (arr[x] != x) {
            arr[x] = find(arr, arr[x]);
        }
        return arr[x];
    }

    public void union(int[] arr, int x, int y) {
        arr[find(arr, x)] = find(arr, y);
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                union(arr, i, i + 1);
            }
        }
        
        boolean[] ans = new boolean[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = find(arr, u) == find(arr, v);
        }
        
        return ans;
    }
}