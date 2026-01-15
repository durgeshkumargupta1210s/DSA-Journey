class Solution {

    // Time Complexity (TC): O(n log n)
    // - Sorting the array takes O(n log n)
    // - Single pass with HashMap operations takes O(n)
    //
    // Space Complexity (SC): O(n)
    // - HashMap is used to store frequency of elements
    // - Output array of size n/2 is created

    public int[] findOriginalArray(int[] changed) {

        int n = changed.length;

        // If the length of the array is odd, it is impossible
        // to form the original array
        if (n % 2 != 0) {
            return new int[0];
        }

        // Sort the array so that smaller elements are processed first
        // This helps ensure correct greedy pairing (x with 2x)
        Arrays.sort(changed);

        // Frequency map to count occurrences of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Array to store the original values
        int[] ans = new int[n / 2];
        int idx = 0;

        // Iterate through the sorted array to form valid pairs
        for (int num : changed) {

            // If this number has already been used completely, skip it
            if (freq.get(num) == 0) {
                continue;
            }

            // Special case: 0 must be paired with another 0
            if (num == 0) {

                // If fewer than two zeros are available, pairing is impossible
                if (freq.get(0) < 2) {
                    return new int[0];
                }

                // Add 0 to the original array
                ans[idx++] = 0;

                // Consume two zeros
                freq.put(0, freq.get(0) - 2);
                continue;
            }

            // Calculate the doubled value
            int doubled = num * 2;

            // If doubled value does not exist or is already exhausted,
            // we cannot form a valid pair
            if (!freq.containsKey(doubled) || freq.get(doubled) == 0) {
                return new int[0];
            }

            // Valid (num, 2*num) pair found
            ans[idx++] = num;

            // Decrease the frequency of both values to mark them as used
            freq.put(num, freq.get(num) - 1);
            freq.put(doubled, freq.get(doubled) - 1);
        }

        // Return the reconstructed original array
        return ans;
    }
}
