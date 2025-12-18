class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;

        int maxWater=0;

        while(left<right){
            int width=right-left;
            int hei=Math.min(height[left], height[right]);
            int current=width * hei;

            maxWater=Math.max(maxWater, current);

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