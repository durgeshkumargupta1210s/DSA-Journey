class Solution {
    public int longestOnes(int[] nums, int k) {
        return longestsubarray(nums,k);
    }

    public static int longestsubarray(int[] nums, int k) {
		// TODO Auto-generated method stub
		int si=0, ans=0,count=0;
        for(int ei=0; ei<nums.length; ei++){
            if(nums[ei]==0){
                count++;
            }
            while(count>k){
                if(nums[si]==0){
                    count--;
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);
        }

        return ans;
		
	}
}