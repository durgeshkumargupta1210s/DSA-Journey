class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();

        int ans=Integer.MAX_VALUE;
        int si=0;
        int sum=0;
        for(int ei=0; ei<nums.length; ei++){
            map.put(nums[ei], map.getOrDefault(nums[ei],0)+1);

            if(map.get(nums[ei])==1){
                sum+=nums[ei];
            }

            while(sum>=k){
                ans = Math.min(ans, ei - si + 1);
                int remo=nums[si];
                map.put(remo,map.get(remo)-1);

                if(map.get(remo)==0){
                    map.remove(remo);
                    sum-=remo;
                }
                si++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}