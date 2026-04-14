class Solution {
    public int minJumps(int[] arr) {

        // Step 1: Build a map → value → list of indices having that value
        // This helps us jump to all same-value indices in O(1) lookup
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        // Step 2: BFS setup
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];

        // Start from index 0
        q.add(0);
        visited[0] = true;

        // step → number of jumps (levels in BFS)
        int step = -1;

        // Step 3: BFS traversal
        while (!q.isEmpty()) {
            int size = q.size();

            // Each level represents one jump
            step++;

            for (int i = 0; i < size; i++) {
                int index = q.poll();

                // ✅ If we reach last index → return steps
                if (index == arr.length - 1) {
                    return step;
                }

                // 🔹 Move to index + 1
                if (index + 1 < arr.length && !visited[index + 1]) {
                    q.add(index + 1);
                    visited[index + 1] = true;
                }

                // 🔹 Move to index - 1
                if (index - 1 >= 0 && !visited[index - 1]) {
                    q.add(index - 1);
                    visited[index - 1] = true;
                }

                // 🔹 Move to all indices having same value
                if (map.containsKey(arr[index])) {
                    for (int next : map.get(arr[index])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }

                // ⚡ Optimization:
                // Once processed, remove this value from map
                // to avoid redundant future traversals
                map.remove(arr[index]);
            }
        }

        // If unreachable (edge case)
        return -1;
    }
}