class Solution {
    
    private static final long N=1000_000_007;
    public int minNonZeroProduct(int p) {
        long max=(1L<<p)-1;
        long power=(max-1)/2;
        long ways=pow(max-1,power);

        return (int)((max%N*ways)%N);
    }
    private long pow(long p,long a){
    long result=1;
    p%=N;
    while(a>0){
        if(a%2==1){
            result=(result*p)%N;
        }
        p=(p*p)%N;
        a/=2;
    }
    return result;
    }
}