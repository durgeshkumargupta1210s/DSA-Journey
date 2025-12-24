import java.util.*;

class Solution {

    private static final int LIMIT = 20000;
    private static final int BOUND = 1_000_000;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(encode(b[0], b[1]));
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] finish, Set<Long> blocked) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(start);
        visited.add(encode(start[0], start[1]));

        while (!q.isEmpty() && visited.size() <= LIMIT) {
            int[] cur = q.poll();

            if (cur[0] == finish[0] && cur[1] == finish[1]) {
                return true;
            }

            for (int[] d : DIRS) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= BOUND || ny >= BOUND) continue;

                long key = encode(nx, ny);
                if (blocked.contains(key) || visited.contains(key)) continue;

                visited.add(key);
                q.offer(new int[]{nx, ny});
            }
        }

        // Escaped the possible enclosure
        return visited.size() > LIMIT;
    }

    private long encode(int x, int y) {
        return ((long) x << 32) | y;
    }
}
