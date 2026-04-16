class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: Build map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Process queries
        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // If only one occurrence
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            // Binary search to find position
            int pos = Collections.binarySearch(list, q);

            int prev = (pos - 1 + list.size()) % list.size();
            int next = (pos + 1) % list.size();

            int prevIdx = list.get(prev);
            int nextIdx = list.get(next);

            // Circular distance
            int d1 = Math.abs(q - prevIdx);
            d1 = Math.min(d1, n - d1);

            int d2 = Math.abs(q - nextIdx);
            d2 = Math.min(d2, n - d2);

            result.add(Math.min(d1, d2));
        }

        return result;
    }
}