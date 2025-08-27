class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
     return range_sum(nums,n,left,right);   
    }
    private static int  range_sum(int[] nums, int n, int left, int right) {
		// TODO Auto-generated method stub
		int MOD = 1_000_000_007;
		ArrayList<Long> al=new ArrayList<>();
		
		for(int i=0; i<nums.length; i++) {
			long sum=0;
			for(int j=i; j<nums.length; j++) {
				sum+=nums[j];
				al.add(sum);
			}
		}
		Collections.sort(al);
		long sum=0;
		for(int i=left-1; i<right; i++) {
			sum=(sum+al.get(i))%MOD;
		}
		return (int)sum;
	}

}