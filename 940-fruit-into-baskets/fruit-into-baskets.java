class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int ans=0,si=0;
         for(int ei=0; ei<fruits.length; ei++){
            // growing phase
            map.put(fruits[ei],map.getOrDefault(fruits[ei],0)+1);

            // shrinking phase
            while(map.size()>2){
                map.put(fruits[si],map.get(fruits[si])-1);
                if(map.get(fruits[si])==0){
                    map.remove(fruits[si]);
                }
                si++;
            }
            // answer update
            ans=Math.max(ans,ei-si+1);

        }
        return ans;
        
    }
}