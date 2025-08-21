class Solution {
    public int[] sortedSquares(int[] nums) {
        return Sorted_square(nums);
    }
    public static int []  Sorted_square(int[] nums) {
		// TODO Auto-generated method stub
		for(int i=0; i<nums.length; i++) {
			nums[i]=nums[i]*nums[i];
		}
		Arrays.sort(nums);
		return nums;
		
	}

}