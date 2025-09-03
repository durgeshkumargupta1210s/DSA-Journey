class Solution {
    public int rob(int[] nums) {
      return RobberBU(nums);  
    }
    public static int RobberBU(int[] arr) {
		if(arr.length==1) {
			return arr[0];
		}
		int [] dp=new int[arr.length];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[0], arr[1]);
		
		for(int i=2; i<dp.length; i++) {
			int rob=arr[i]+dp[i-2];
			int Dont_rob=dp[i-1];
			dp[i]=Math.max(rob, Dont_rob);
		}
		return dp[dp.length-1];
	}
}