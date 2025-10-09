class Solution {
    public long minCost(int[] nums, int[] cost) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        int low=min;
        int high=max;

        while(low<high){
            int mid=(low+high)/2;

            long midcost=calculate(nums,cost, mid);
            long midnext=calculate(nums,cost, mid+1);

            if(midcost>midnext){
                low=mid+1;
            }
            else{
                high=mid;
            }
           
        }
        return calculate(nums,cost,low);
        
    }
    public long calculate(int [] nums, int [] cost, int target){
        long total=0;

        for(int i=0; i<nums.length; i++){
            total+=(long)Math.abs(nums[i]-target)*cost[i];
        }
        return total;
    }
}