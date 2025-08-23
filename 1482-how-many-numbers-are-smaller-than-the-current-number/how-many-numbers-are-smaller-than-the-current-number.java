class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        return smaller_count(nums);
    }
    private static int [] smaller_count(int[] nums) {
		// TODO Auto-generated method stub
		int [] temp=new int [nums.length];
		for(int i=0; i<nums.length; i++) {
			int count=0;
			for(int j=0; j<nums.length; j++) {
				if(nums[i]>nums[j]) {
					count++;
				}
			}
			temp[i]=count;
		}
		return temp;
		
		
	}
}