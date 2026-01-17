class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }

        for(int [] arr : operations){
            int ele=arr[0];
            int replace=arr[1];

            int idx=map.get(ele);
            nums[idx]=replace;
            map.remove(ele);
            map.put(replace, idx);
        }

        return nums;
    }
}