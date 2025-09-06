import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballToColor = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];

            // If this ball was already painted
            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);
                // decrease count of old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            // Paint with new color
            ballToColor.put(ball, newColor);
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);

            // Number of distinct colors
            result[i] = colorCount.size();
        }

        return result;
    }
}
