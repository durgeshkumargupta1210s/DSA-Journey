class Solution {
    public double myPow(double x, int n) {
        long N = n;
         return power(x,N);
        
    }
    public static double power(double x, long N){
        if(N==0){
            return 1;
        }
        double ans=Math.pow(x,N-1);
        return ans*x;
    }
}