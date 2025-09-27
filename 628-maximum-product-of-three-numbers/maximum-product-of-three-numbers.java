class Solution {
    public int maximumProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int n=nums.length;
        Arrays.sort(nums);
        int product1=nums[n-1]*nums[n-2]*nums[n-3]; // if only positive 
        int product2=nums[0]*nums[1]*nums[n-1];// if two -ve are at the starting and and a positive are on the last
           
        ans=Math.max(product1,product2);
        return ans;
        
    }
}