class Solution {
    public boolean predictTheWinner(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int total=0;
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
        }

        int p1=OptimalGameStrategy(nums,left,right);
        int p2=total-p1;

        return p1>=p2;
        
    }
    public int OptimalGameStrategy(int [] nums, int left, int right){
        if(left>right){
            return 0;
        }

        int choose_left=nums[left]+Math.min(OptimalGameStrategy(nums,left+2,right), OptimalGameStrategy(nums,left+1, right-1));

        int choose_right=nums[right]+Math.min(OptimalGameStrategy(nums,left+1,right-1), OptimalGameStrategy(nums,left, right-2));

        return Math.max(choose_left, choose_right);


    }
}