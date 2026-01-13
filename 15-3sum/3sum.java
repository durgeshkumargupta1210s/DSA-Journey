class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                    Arrays.sort(nums);
        int n=nums.length;
        Set<List<Integer>> result=new HashSet<>();

        for(int i=0; i<n; i++){
            Set<Integer> temp=new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third=-(nums[i]+nums[j]);
                if(temp.contains(third)){
                    List<Integer> triplet=Arrays.asList(nums[i],nums[j],third);
                    result.add(triplet);
                }
                temp.add(nums[j]);
            }
        }

        return new ArrayList<>(result);

    }
}