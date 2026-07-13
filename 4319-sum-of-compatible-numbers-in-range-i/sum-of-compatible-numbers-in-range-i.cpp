class Solution {
public:
    int sumOfGoodIntegers(int n, int k) {
        int sum=0;
        int maxy=max(1,n-k);

        for(int i=maxy; i<=n+k; i++){
            if((n & i)==0){
                sum+=i;
            }
        }
        return sum;
        
    }
};