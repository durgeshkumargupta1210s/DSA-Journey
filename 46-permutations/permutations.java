class Solution {
    static List<List<Integer>>list;
    public List<List<Integer>> permute(int[] nums) {
        list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        solve(nums,visited,new ArrayList<>());
        return list;
        
    }
    public static void solve(int[] nums,boolean[] visited,List<Integer>curr){
        if(curr.size()==nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i]=true;
                curr.add(nums[i]);
                solve(nums,visited,curr);
                curr.remove(curr.size()-1);
                visited[i]=false;
            }
        }
    }
}