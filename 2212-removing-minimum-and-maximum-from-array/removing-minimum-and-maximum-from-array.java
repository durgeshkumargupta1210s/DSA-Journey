class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }

            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int d1 = right + 1;
        int d2 = nums.length - left;
        int d3 = (left + 1) + (nums.length - right);

        return Math.min(d1, Math.min(d2, d3));
    }
}