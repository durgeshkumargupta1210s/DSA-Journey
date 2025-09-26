class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int normalSum=Kadans(nums);
        int circularSum=TotalSum(nums)-minimumSubarraySum(nums);
        if (normalSum < 0) return normalSum;
        return Math.max(normalSum,circularSum);
        
    }
    public static int Kadans(int [] arr){
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            ans=Math.max(ans,sum);

            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }

    public static int TotalSum(int [] arr){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static int minimumSubarraySum(int [] arr){
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            ans=Math.min(ans,sum);

            if(sum>0){
                sum=0;
            }
        }
        return ans;
    }
}