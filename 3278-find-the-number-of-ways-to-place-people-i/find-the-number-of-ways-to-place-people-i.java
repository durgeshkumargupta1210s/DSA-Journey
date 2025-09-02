import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Step 1: Sort points by x ascending, and for equal x → y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // descending y if same x
            }
            return a[0] - b[0]; // ascending x
        });

        int n = points.length;
        int ans = 0;

        // Step 2: For each point as A, check possible B’s
        for (int i = 0; i < n; i++) {
            int yi = points[i][1];
            int maxY = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int yj = points[j][1];

                // Condition: A.y >= B.y and B.y > maxY
                if (yi >= yj && yj > maxY) {
                    ans++;
                    maxY = yj; // update boundary
                }
            }
        }
        return ans;
    }
}
