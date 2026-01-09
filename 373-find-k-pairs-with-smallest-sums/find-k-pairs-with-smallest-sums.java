class Solution {

    // Helper class to store a pair along with its sum
    static class Pair {
        int sum;  // sum of nums1[i] + nums2[j]
        int i;    // index in nums1
        int j;    // index in nums2

        // Constructor to initialize the pair
        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // Result list to store k pairs with smallest sums
        List<List<Integer>> list = new ArrayList<>();

        // Edge case: if any array is empty or k is zero, return empty list
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return list;
        }

        // Min-heap (priority queue) ordered by pair sum
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum - b.sum
        );

        /*
         * Initialize the heap with pairs:
         * (nums1[i], nums2[0]) for i = 0 to min(k, nums1.length) - 1
         * These represent the smallest possible pairs for each nums1[i]
         */
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new Pair(nums1[i] + nums2[0], i, 0));
        }

        /*
         * Extract the k smallest pairs
         * Each time we remove the smallest sum pair from the heap
         */
        while (!pq.isEmpty() && k > 0) {

            // Get the pair with the smallest sum
            Pair current = pq.poll();

            // Add the actual values (nums1[i], nums2[j]) to the result
            list.add(Arrays.asList(
                nums1[current.i],
                nums2[current.j]
            ));

            // One pair has been added
            k--;

            /*
             * Push the next possible pair using the same nums1 index
             * but moving to the next element in nums2
             */
            if (current.j + 1 < nums2.length) {
                pq.add(new Pair(
                    nums1[current.i] + nums2[current.j + 1],
                    current.i,
                    current.j + 1
                ));
            }
        }

        // Return the list of k smallest sum pairs
        return list;
    }
}
