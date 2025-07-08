class Solution {
    public int missingNumber(int[] nums) {
        return missyou(nums);
    }
    private static int missyou(int[] nums) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		for(int ele : nums) {
			set.add(ele);
		}
		for(int i=0; i<=nums.length; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
}