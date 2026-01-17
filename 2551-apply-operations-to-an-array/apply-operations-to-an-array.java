class Solution {
    public int[] applyOperations(int[] nums) {

        // Step 1: merge equal adjacent elements
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: move non-zero elements to the left
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[c++] = nums[i];
            }
        }

        // Step 3: fill remaining positions with 0
        while(c < nums.length){
            nums[c++] = 0;
        }

        return nums;
    }
}
