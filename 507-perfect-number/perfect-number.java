class Solution {
    public boolean checkPerfectNumber(int num) {
        return perfect_number(num);
    }
    public static boolean perfect_number(int num){
        int sum=0;
        for(int i=1; i<num; i++){
            if(num%i==0){
                sum+=i;
            }
        }
        if(sum==num){
            return true;
        }
        return false;
    }
}