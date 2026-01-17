class Solution {
    public int alternateDigitSum(int n) {
        String str=n+"";
        int sum=0;
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(i%2==0){
                sum+=ch-'0';
            }
            else{
                sum-=ch-'0';
            }
        }
        return sum;
        
    }
}