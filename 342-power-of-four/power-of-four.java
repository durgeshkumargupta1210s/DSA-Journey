class Solution {
    public boolean isPowerOfFour(int n) {
        return power(n);
    }
    public static boolean power(int n){
        if(n<=0){
            return false;
        }
        while(n%4==0){
            n=n/4;
        }
        if(n==1){
            return true;
        }
        return false;
    }
}