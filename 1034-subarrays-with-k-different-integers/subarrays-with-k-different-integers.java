class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
      return countSubarrayWithDistinctElement(nums,k)-countSubarrayWithDistinctElement(nums,k-1);
    }
    public int countSubarrayWithDistinctElement(int[] nums, int k){
        int si=0;
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int ei=0; ei<nums.length; ei++){
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);

            while(map.size()>k){
                map.put(nums[si],map.get(nums[si])-1);

                if(map.get(nums[si])==0){
                    map.remove(nums[si]);
                }

                si++;
            }

            count+=(ei-si+1);
        }
        return count;
    }
}