class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set=new HashSet<>();
        boolean[] visited=new boolean[nums.length];
        solve(nums,set,visited,new ArrayList<>());
        return new ArrayList<>(set);
        
    }
    public static void solve(int [] nums, HashSet<List<Integer>>set, boolean[] visited, List<Integer>list){
        if(list.size()==nums.length){
            set.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                solve(nums,set,visited,list);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }

    }
}