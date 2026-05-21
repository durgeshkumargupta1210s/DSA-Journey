class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int longest = 0;

       
        for (int num : arr2) {

            while (num > 0 && !set.contains(num)) {
                num /= 10;
            }

            if (num > 0) {
                longest = Math.max(longest, String.valueOf(num).length());
            }
        }

        return longest;
    }
}