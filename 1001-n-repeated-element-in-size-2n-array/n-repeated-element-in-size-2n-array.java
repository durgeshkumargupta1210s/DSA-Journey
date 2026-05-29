class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n=nums.length/2;

        for(int ele : map.keySet() ){
            if(map.get(ele)==n){
                return ele;
            }
        }

        return n;

        
    }
}