class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
      return   All_Pairing(nums1,nums2);

        
    }
    public static int All_Pairing(int[] nums1, int[] nums2) {

        // Length of nums1
        int n = nums1.length;

        // Length of nums2
        int m = nums2.length;

        /*
         * If both arrays have even lengths:
         * Each element from nums1 and nums2 appears an even number of times
         * in all pairings.
         * Since XOR of even occurrences cancels out, result is 0.
         */
        if (n % 2 == 0 && m % 2 == 0) {
            return 0;
        }

        // XOR of all elements in nums1
        int xor1 = Bitwise_XOR(nums1);

        // XOR of all elements in nums2
        int xor2 = Bitwise_XOR(nums2);

        /*
         * If both lengths are odd:
         * Each element from nums1 appears odd times,
         * and each element from nums2 also appears odd times.
         * Therefore, both contribute to the final XOR.
         */
        if (n % 2 == 1 && m % 2 == 1) {
            return xor1 ^ xor2;
        }

        /*
         * If nums1 length is odd and nums2 length is even:
         * Elements of nums2 appear odd times in pairings,
         * so only nums2 contributes to the result.
         */
        else if (n % 2 == 1) {
            return xor2;
        }

        /*
         * If nums2 length is odd and nums1 length is even:
         * Elements of nums1 appear odd times in pairings,
         * so only nums1 contributes to the result.
         */
        else {
            return xor1;
        }
    }

    /**
     * Helper method to compute XOR of all elements in an array.
     */
    private static int Bitwise_XOR(int[] arr) {

        // Stores cumulative XOR value
        int xor = 0;

        // XOR each element with the current result
        for (int v : arr) {
            xor ^= v;
        }

        // Return final XOR value
        return xor;
    }
}