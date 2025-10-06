class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0; i<flowerbed.length; i++){
            if((i==0 ||flowerbed[i-1]!=1) && (i==flowerbed.length-1 ||flowerbed[i+1]!=1) && flowerbed[i]==0){
                count++;
                flowerbed[i]=1;
            }
        }
        return count>=n;
        
    }
}