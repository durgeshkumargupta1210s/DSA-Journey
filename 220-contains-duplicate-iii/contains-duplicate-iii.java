class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeMap<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {

            long curr = nums[i];

            // Smallest element >= curr - valueDiff
            Long candidate = map.ceilingKey(curr - valueDiff);

            if (candidate != null && candidate <= curr + valueDiff) {
                return true;
            }

            // Insert current number
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // Remove element leaving the sliding window
            if (i >= indexDiff) {
                long remove = nums[i - indexDiff];

                if (map.get(remove) == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, map.get(remove) - 1);
                }
            }
        }

        return false;
    }
}