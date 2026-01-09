class Solution {
    public int minimumDistance(int[] nums) {

        // Map to store all indices for each value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        // Build the index list for each number
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Process each number's indices
        for (List<Integer> list : map.values()) {

            // At least 3 occurrences are required
            if (list.size() < 3) {
                continue;
            }

            // Check all consecutive triples
            for (int i = 0; i + 2 < list.size(); i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                int c = list.get(i + 2);

                // Since a < b < c, this equals 2 * (c - a)
                int dist = Math.abs(a - b)
                         + Math.abs(b - c)
                         + Math.abs(c - a);

                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
