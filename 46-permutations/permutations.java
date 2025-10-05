class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> temp=new ArrayList<>();
        boolean [] backTracking=new boolean[nums.length];
        generatePermutations(nums,temp,backTracking);

        return result;

        
    }

    public void generatePermutations(int[] nums, List<Integer> temp, boolean [] backTracking ){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!backTracking[i]){
                backTracking[i]=true;
                temp.add(nums[i]);
                generatePermutations(nums,temp,backTracking);
                temp.remove(temp.size()-1);
                backTracking[i]=false;
            }
        }
    }
}