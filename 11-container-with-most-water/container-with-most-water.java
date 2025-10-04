class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxWater=0;
        while(left<right){
            int width=right-left;
            int heigh=Math.min(height[left],height[right]);
            int currentWater=width*heigh;
            maxWater=Math.max(maxWater,currentWater);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }

        }
        return maxWater;

        
    }
}