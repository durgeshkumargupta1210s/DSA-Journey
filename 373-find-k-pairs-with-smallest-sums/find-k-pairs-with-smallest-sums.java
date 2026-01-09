import java.util.*;

class Solution {

    // Helper class to store heap entries
    static class Pair {
        int sum;
        int i; // index in nums1
        int j; // index in nums2

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // Edge cases
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min heap based on sum
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum - b.sum
        );

        // Push initial pairs (nums1[i], nums2[0])
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new Pair(nums1[i] + nums2[0], i, 0));
        }

        // Extract k smallest pairs
        while (!pq.isEmpty() && k > 0) {
            Pair curr = pq.poll();
            int i = curr.i;
            int j = curr.j;

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Push next pair with same nums1[i] and next nums2 index
            if (j + 1 < nums2.length) {
                pq.offer(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
            }
        }

        return result;
    }
}
