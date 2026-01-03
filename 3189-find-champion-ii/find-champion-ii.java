class Solution {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int [] arr : edges){
            set.add(arr[1]);
        }

        for(int i=0; i<n; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        if(list.size()>=2){
            return -1;
        }
        return list.get(0);
        


        
    }
}