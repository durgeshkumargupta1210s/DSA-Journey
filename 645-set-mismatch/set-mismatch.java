class Solution {
    public int[] findErrorNums(int[] nums) {
      return errornums(nums)  ;
    }
    private static int[] errornums(int[] nums) {
		// TODO Auto-generated method stub
		Arrays.sort(nums);
		int a=0;
		int b=0;
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==nums[i-1]) {
				 a=nums[i];
				 break;
			}
		}
		int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        b = expectedSum - (actualSum - a);
		return new int[] {a,b};
	}

}