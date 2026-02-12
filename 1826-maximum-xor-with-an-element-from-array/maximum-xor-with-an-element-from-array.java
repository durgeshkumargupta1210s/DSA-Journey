import java.util.*;

class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {

        int n = nums.length;
        int qn = queries.length;

        // Step 1: Store queries with original index
        int[][] q = new int[qn][3];
        for (int i = 0; i < qn; i++) {
            q[i][0] = queries[i][0]; // xi
            q[i][1] = queries[i][1]; // mi
            q[i][2] = i;             // original index
        }

        // Step 2: Sort nums
        Arrays.sort(nums);

        // Step 3: Sort queries by mi
        Arrays.sort(q, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 4: Create Trie
        Trie trie = new Trie();

        int[] ans = new int[qn];

        int j = 0;

        // Step 5: Process queries
        for (int i = 0; i < qn; i++) {

            int xi = q[i][0];
            int mi = q[i][1];
            int originalIndex = q[i][2];

            // Insert valid nums into Trie
            while (j < n && nums[j] <= mi) {
                trie.insert(nums[j]);
                j++;
            }

            // If no number inserted
            if (j == 0) {
                ans[originalIndex] = -1;
            }
            else {
                ans[originalIndex] = trie.getMaxXor(xi);
            }
        }

        return ans;
    }


    // Trie Class
    static class Trie {

        static class Node {
            Node zero;
            Node one;
        }

        Node root;

        Trie() {
            root = new Node();
        }

        // Insert number into Trie
        void insert(int num) {

            Node curr = root;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;

                if (bit == 0) {
                    if (curr.zero == null)
                        curr.zero = new Node();
                    curr = curr.zero;
                }
                else {
                    if (curr.one == null)
                        curr.one = new Node();
                    curr = curr.one;
                }
            }
        }

        // Get maximum XOR
        int getMaxXor(int num) {

            Node curr = root;

            int maxXor = 0;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;

                // Try opposite bit
                if (bit == 0) {

                    if (curr.one != null) {
                        maxXor |= (1 << i);
                        curr = curr.one;
                    }
                    else {
                        curr = curr.zero;
                    }
                }
                else {

                    if (curr.zero != null) {
                        maxXor |= (1 << i);
                        curr = curr.zero;
                    }
                    else {
                        curr = curr.one;
                    }
                }
            }

            return maxXor;
        }
    }
}
