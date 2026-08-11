class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        if(nums.length==1){
            return nums[0]+1;
        }

        int sum=nums[0];

        
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }
            else{
                while(set.contains(sum)){
                    sum=sum+1;
                }
                break;
            }
        }
        return sum;
        
    }
}