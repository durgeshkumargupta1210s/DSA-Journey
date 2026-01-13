class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        Set<List<Integer>> result=new HashSet<>();

        for(int i=0; i<n-1; i++){
            int lo = i+1;
            int hi = n-1;
            while(lo < hi){
                int sum = (nums[i] + nums[lo] + nums[hi]);

                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    lo++;
                    hi--;
                }else if(sum > 0) hi--;
                else lo++;
            }
            
        }

        return new ArrayList<>(result);

    }
}