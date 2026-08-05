class Solution {
   
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        HashSet<List<Integer>> set=new HashSet<>();
        solve(nums,0,set,new ArrayList<>());
        return new ArrayList<>(set);
        
    }
    public static void solve(int [] nums, int idx, HashSet<List<Integer>> set, List<Integer> curr){
        if(idx==nums.length){
            set.add(new ArrayList<>(curr));
            return;
        }

        solve(nums,idx+1,set,curr);
        curr.add(nums[idx]);
        solve(nums,idx+1, set, curr);
        curr.remove(curr.size()-1);
    }
}