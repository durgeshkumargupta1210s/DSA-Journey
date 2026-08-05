class Solution {
    static List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.clear();
        solve(nums,0,new ArrayList<>());
        return result;
    }
    public static void solve(int [] nums,int idx,List<Integer> curr){
        if(idx==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        solve(nums,idx+1,curr);
        curr.add(nums[idx]);
        solve(nums,idx+1,curr);
        curr.remove(curr.size()-1);
    }
}