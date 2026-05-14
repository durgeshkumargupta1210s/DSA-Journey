class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i])==1){
                if(map.get(nums[i]+1)==null && map.get(nums[i]-1)==null){
                   list.add(nums[i]);
                }
            }
        }
        return list;
        
    }
}