class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Set<Integer> blocked = new HashSet<>();
        for (int f : forbidden) {
            blocked.add(f);
        }

        // FIX: Use safe global upper bound
        int upperBound = 6000;

        boolean[][] visited = new boolean[upperBound + 1][2];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int pos = curr[0];
            int lastBack = curr[1];
            int steps = curr[2];

            if (pos == x) {
                return steps;
            }

            // Forward jump
            int forward = pos + a;
            if (forward <= upperBound &&
                !blocked.contains(forward) &&
                !visited[forward][0]) {

                visited[forward][0] = true;
                q.offer(new int[]{forward, 0, steps + 1});
            }

            // Backward jump (only if previous was not backward)
            int backward = pos - b;
            if (lastBack == 0 &&
                backward >= 0 &&
                !blocked.contains(backward) &&
                !visited[backward][1]) {

                visited[backward][1] = true;
                q.offer(new int[]{backward, 1, steps + 1});
            }
        }

        return -1;
    }
}
