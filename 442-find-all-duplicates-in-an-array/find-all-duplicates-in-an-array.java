class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> twice=new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i=1; i<nums.length;i++){
                if(nums[i]==nums[i-1]){
                    twice.add(nums[i]);
                }
            
            
        }
        // int [] result=new int[twice.size()];
        // for(int i=0;i<twice.size();i++){
        //     result[i]=twice.get(i);
        // }
        // return result;
        return twice;
        
    }
}