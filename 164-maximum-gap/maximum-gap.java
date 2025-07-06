class Solution {
    public int maximumGap(int[] nums) {
       return maximum_gap(nums); 
    }
    private static int maximum_gap(int[] nums) {
		// TODO Auto-generated method stub
		int ans=0;
		if(nums.length<2) {
			return ans;
		}
		Arrays.sort(nums);
		for(int i=1; i<nums.length; i++) {
			int diff=nums[i]-nums[i-1];
			ans=Math.max(ans,diff);
		}
		return ans;
	}
}