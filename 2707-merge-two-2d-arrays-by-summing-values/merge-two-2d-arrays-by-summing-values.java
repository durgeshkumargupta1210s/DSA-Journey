import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Using TreeMap to automatically sort by key (ID)
        Map<Integer, Integer> map = new TreeMap<>();

        // Process nums1
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i][0];
            int value = nums1[i][1];
            map.put(key, map.getOrDefault(key, 0) + value);
        }

        // Process nums2
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i][0];
            int value = nums2[i][1];
            map.put(key, map.getOrDefault(key, 0) + value);
        }

        // Convert map entries into a 2D array
        int[][] result = new int[map.size()][2];
        int index = 0;

        for (int key : map.keySet()) {
            result[index][0] = key;
            result[index][1] = map.get(key);
            index++;
        }

        return result;
    }
}
