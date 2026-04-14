class Solution {

    public boolean canReach(int[] arr, int start) {

        // visited array to avoid infinite loops (cycles)
        boolean[] visited = new boolean[arr.length];

        // Start DFS from given index
        return solve(arr, start, visited);
    }

    public static boolean solve(int[] arr, int i, boolean[] visited) {

        // ❌ Base Case 1:
        // If index goes out of bounds OR already visited → invalid path
        if (i >= arr.length || i < 0 || visited[i]) {
            return false;
        }

        // ✅ Base Case 2:
        // If we reach a cell with value 0 → success
        if (arr[i] == 0) {
            return true;
        }

        // Mark current index as visited to prevent cycles
        visited[i] = true;

        // Explore both possible jumps:
        // 1. Forward jump → i + arr[i]
        boolean forward = solve(arr, i + arr[i], visited);

        // 2. Backward jump → i - arr[i]
        boolean backward = solve(arr, i - arr[i], visited);

        // If any path leads to 0 → return true
        return forward || backward;
    }
}