class Solution {
    public int minMoves(int[] nums) {
      return min_move(nums);  
    }
    private static int  min_move(int[] nums) {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		int ans=0;
		for(int i=0; i<nums.length; i++) {
			min=Math.min(min, nums[i]);
		}
		for(int ele : nums) {
			ans+=Math.abs(min-ele);
		}
		return ans;
	}
}