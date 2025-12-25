import java.util.*;

class Solution {

    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        long operations = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            List<Integer> group = new ArrayList<>();
            int cur = i;

            // MOD-based cycle traversal
            while (!visited[cur]) {
                visited[cur] = true;
                group.add(arr[cur]);
                cur = (cur + k) % n;
            }

            Collections.sort(group);
            int median = group.get(group.size() / 2);

            for (int val : group) {
                operations += Math.abs(val - median);
            }
        }

        return operations;
    }
}
