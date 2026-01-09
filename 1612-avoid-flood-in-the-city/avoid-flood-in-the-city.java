import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {

        // ans[i] = -1  → raining day
        // ans[i] = lakeNumber → dry this lake on day i
        // ans[i] = 1   → unused dry day (default valid value)
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);

        // map stores: lake -> last index (day) when this lake was filled
        Map<Integer, Integer> map = new HashMap<>();

        // TreeSet stores indices of days where rains[i] == 0 (dry days)
        // TreeSet keeps indices sorted automatically
        TreeSet<Integer> set = new TreeSet<>();

        // Traverse each day
        for (int i = 0; i < rains.length; i++) {

            int lake = rains[i];

            // Case 1: Dry day (rains[i] == 0)
            if (lake == 0) {

                // Store the index of this dry day
                set.add(i);

                // Temporary value; may be overwritten later
                ans[i] = 1;
            }

            // Case 2: Raining day (rains[i] > 0)
            else {

                // Mark raining day
                ans[i] = -1;

                // If this lake was already filled earlier
                if (map.containsKey(lake)) {

                    // Last day when this lake was filled
                    int lastidx = map.get(lake);

                    // Find the earliest dry day strictly AFTER lastidx
                    // TreeSet.higher(x) returns the smallest element > x
                    Integer nearestzeroidx = set.higher(lastidx);

                    // If no such dry day exists, flood is unavoidable
                    if (nearestzeroidx == null) {
                        return new int[0];
                    }

                    // Use this dry day to dry the lake
                    ans[nearestzeroidx] = lake;

                    // Remove the dry day since it is now used
                    set.remove(nearestzeroidx);
                }

                // Update the last filled day of this lake
                map.put(lake, i);
            }
        }

        // Successfully avoided all floods
        return ans;
    }
}
