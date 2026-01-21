class Solution {

    // This method returns the XOR sum of all pairwise ANDs
    // i.e., ⊕ over all (arr1[i] & arr2[j])
    public int getXORSum(int[] arr1, int[] arr2) {

        // This variable will store XOR of all elements in arr2
        int xor = 0;

        // This variable will store the final result
        int ans = 0;

        /*
         * Step 1: Compute XOR of all elements in arr2
         * This works because AND distributes over XOR:
         * a & (b ^ c) = (a & b) ^ (a & c)
         */
        for (int i = 0; i < arr2.length; i++) {
            xor ^= arr2[i];
        }

        /*
         * Step 2: AND each element of arr1 with the XOR of arr2
         * and accumulate the result using XOR
         */
        for (int i = 0; i < arr1.length; i++) {
            ans ^= (arr1[i] & xor);
        }

        // Final XOR sum of all pairwise ANDs
        return ans;
    }
}
