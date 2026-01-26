class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer i starts from the last valid element in nums1
        int i = m - 1;

        // Pointer j starts from the last element in nums2
        int j = n - 1;

        // Pointer k starts from the last position of nums1 (total size = m + n)
        int k = m + n - 1;

        // Merge nums1 and nums2 from the back
        // Continue until either nums1 or nums2 is completely processed
        while (i >= 0 && j >= 0) {

            // If current element in nums2 is larger,
            // place it at the end of nums1
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;  // Move nums2 pointer left
            }

            // Otherwise, place current element of nums1 itself
            else {
                nums1[k] = nums1[i];
                i--;  // Move nums1 pointer left
            }

            // Move the final position pointer left
            k--;
        }

        // If nums2 still has remaining elements,
        // copy them into nums1
        // (No need to copy nums1 leftovers because they are already in place)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;  // Move nums2 pointer left
            k--;  // Move merged pointer left
        }
    }
}
