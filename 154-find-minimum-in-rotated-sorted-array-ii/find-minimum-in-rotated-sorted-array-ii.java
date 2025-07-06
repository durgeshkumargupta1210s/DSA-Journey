class Solution {
    public int findMin(int[] nums) {
      return minimum(nums)  ;
    }
    public static int minimum(int[] nums){
        Set<Integer> s=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            s.add(nums[i]);
        }
        int min=Integer.MAX_VALUE;
        for(int ele : s){
            if(min>ele){
                min=ele;
            }
        }
        return min;
    }
}