class Solution {
    static List<List<Integer>>list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list=new ArrayList<>();
        solve(candidates,target,new ArrayList<>(),0);
        return list;
        
    }
    public static void solve(int [] nums, int target, List<Integer> curr, int idx){
        if(target==0){
            list.add(new ArrayList<>(curr));
            return;
        }
        if(idx==nums.length){
            return;
        }

        solve(nums,target,curr,idx+1);

        if(target>=nums[idx]){
            curr.add(nums[idx]);
            solve(nums,target-nums[idx],curr,idx);
            curr.remove(curr.size()-1);
        }
    }
}