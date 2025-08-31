class Solution {
    public int maxOperations(int[] nums, int k) {
        return max_operations(nums,k);
    }
    private static int max_operations(int[] nums, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		int count=0;
		int left=0;
		int right=nums.length-1;
		while(left<right) {
			int sum=nums[left]+nums[right];
			if(sum==k) {
				count++;
				left++;
				right--;
			}
			else if(sum>k) {
				right--;
			}
			else {
				left++;
			}
		}
		return count;
	}
}