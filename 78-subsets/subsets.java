class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current=new ArrayList<>();
        computeSubsets(nums,0, current);
        return result;
    }
    public void computeSubsets(int [] nums,int idx, List<Integer>current){
        if(idx==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // include element
        current.add(nums[idx]);
        computeSubsets(nums,idx+1, current);

        // exclude element
        current.remove(current.size()-1);

        computeSubsets(nums,idx+1,current);
    }
}