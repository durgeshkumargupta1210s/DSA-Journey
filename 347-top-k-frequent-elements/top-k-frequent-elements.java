import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        
        int[] arr = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arr[i++] = entry.getKey();
            if (i == k) break;
        }

        return arr;
    }
}
