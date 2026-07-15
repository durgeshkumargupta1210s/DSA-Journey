class Solution {
    public int gcdOfOddEvenSums(int n) {
       int even=0;
        int odd=0;

        for(int i=1;i<=n; i++){
            odd+=2*n-1;
            even+=2*n;
        }

        return gcd(odd,even);
        
        
    }
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}