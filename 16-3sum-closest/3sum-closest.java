class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int finalSum=Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++ ){
            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int tempSum=nums[i]+nums[left]+nums[right];
                if(Math.abs(tempSum-target)<(Math.abs(finalSum-target))){
                    finalSum=tempSum;
                }
                if(tempSum<target){
                    left++;
                }
                else if(tempSum>target){
                    right--;
                }
                else{
                    return target;
                }

            }
        }
        return finalSum;
        
    }
}