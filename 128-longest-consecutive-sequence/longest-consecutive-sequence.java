class Solution {
    public int longestConsecutive(int[] nums) {

        // Use a HashSet to store all elements
        // This allows O(1) average time lookup
        Set<Integer> set = new HashSet<>();

        // Insert all numbers from the array into the set
        for (int ele : nums) {
            set.add(ele);
        }

        // Variable to store the length of the longest consecutive sequence
        int ans = 0;

        // Traverse through each element in the set
        for (int ele : set) {

            // Check if this element is the start of a sequence
            // A number is the start if (ele - 1) is NOT present
            if (!set.contains(ele - 1)) {

                // Start counting the sequence from this number
                int current = ele;
                int count = 1;

                // Continue checking for the next consecutive numbers
                while (set.contains(current + 1)) {
                    count++;       // increase sequence length
                    current++;     // move to next number
                }

                // Update the maximum sequence length found so far
                ans = Math.max(ans, count);
            }
        }

        // Return the longest consecutive sequence length
        return ans;
    }
}