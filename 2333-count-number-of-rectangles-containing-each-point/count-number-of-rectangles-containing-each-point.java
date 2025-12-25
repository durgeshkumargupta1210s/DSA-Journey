import java.util.*;

class Solution {

    public int[] countRectangles(int[][] rectangles, int[][] points) {

        List<Integer>[] buckets = new ArrayList[101];
        for (int i = 1; i <= 100; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int[] rect : rectangles) {
            int l = rect[0];
            int h = rect[1];
            buckets[h].add(l);
        }

        for (int i = 1; i <= 100; i++) {
            Collections.sort(buckets[i]);
        }

        int[] result = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;

            for (int h = y; h <= 100; h++) {
                List<Integer> list = buckets[h];
                if (!list.isEmpty()) {
                    int idx = lowerBound(list, x);
                    count += list.size() - idx;
                }
            }

            result[i] = count;
        }

        return result;
    }
    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
