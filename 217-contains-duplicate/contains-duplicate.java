class Solution {
    public boolean containsDuplicate(int[] nums) {
        return duplicate(nums);
    }
    public static boolean duplicate(int[] arr) {
        Arrays.sort(arr); 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true; 
            }
        }
        return false;
    }

}