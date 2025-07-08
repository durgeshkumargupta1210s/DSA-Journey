class Solution {
    public int findDuplicate(int[] nums) {
        return duplicate(nums);
    }
    private static int duplicate(int[] nums) {
		// TODO Auto-generated method stub
		int ans=0;
		Arrays.sort(nums);
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==nums[i-1]) {
			 ans=nums[i];
			 break;
			}
		}
		return ans;
	}
}