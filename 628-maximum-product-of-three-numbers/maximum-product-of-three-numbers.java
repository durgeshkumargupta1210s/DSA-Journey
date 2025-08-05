class Solution {
    public int maximumProduct(int[] nums) {
       return maxproduct(nums) ;
    }
    private static int maxproduct(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
  
        int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
       // Product of the two smallest numbers (negative) and the largest number
        int maxProduct2 = nums[0] * nums[1] * nums[n - 1];
        
        return Math.max(maxProduct1, maxProduct2);
    }


}