class Solution {

    // Time Complexity: O(n log n) because of sorting
    // Space Complexity: O(n) because we use a map

    public boolean canReorderDoubled(int[] arr) {

        // Store how many times each number appears
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert int[] to Integer[] so we can sort using custom logic
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort numbers by absolute value
        // This helps handle negative numbers correctly
        Arrays.sort(nums, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        // Try to pair each number with its double
        for (int num : nums) {

            // If this number is already used, skip it
            if (freq.get(num) == 0) {
                continue;
            }

            int doubled = num * 2;

            // If the double does not exist, pairing is impossible
            if (!freq.containsKey(doubled) || freq.get(doubled) == 0) {
                return false;
            }

            // Use one occurrence of num and its double
            freq.put(num, freq.get(num) - 1);
            freq.put(doubled, freq.get(doubled) - 1);
        }

        // All numbers were successfully paired
        return true;
    }
}
