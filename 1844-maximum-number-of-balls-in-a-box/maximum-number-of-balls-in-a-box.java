import java.util.*;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int n = i;
            int sum = 0;

            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int maxBalls = 0;
        for (int count : map.values()) {
            maxBalls = Math.max(maxBalls, count);
        }

        return maxBalls;
    }
}
