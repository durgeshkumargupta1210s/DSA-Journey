class Solution {
    public int subarraySum(int[] nums, int k) {
        int [] prefix=new int[nums.length];
        prefix[0]=nums[0];
        int count=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=1; i<nums.length; i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        map.put(0, 1);

        for(int i=0; i<nums.length; i++){
            int sum=prefix[i];

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
        
    }
}