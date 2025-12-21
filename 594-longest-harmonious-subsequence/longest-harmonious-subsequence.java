class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int longest = 0;
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                int currentLength = freq.get(key) + freq.get(key + 1);
                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}
