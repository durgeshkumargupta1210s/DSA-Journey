class Solution {
    public int numIdenticalPairs(int[] nums) {
      return Identical_pair(nums);  
    }
    private static int Identical_pair(int[] nums) {
		// TODO Auto-generated method stubArrays.sort(nums
		Arrays.sort(nums);
		int count=0;
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums.length; j++) {
				if(nums[i]==nums[j] && i<j) {
					count++;
				}
			}
		}
		return count;
	}
}