class Solution {
    public int countEven(int num) {
        int count=0;

        for(int i=1; i<=num; i++){
           int temp=i;
           int sum=0;
           while(temp>0){
            int rem=temp%10;
            sum+=rem;
            temp/=10;
           }

           if(sum%2==0){
            count++;
           }
        }
        return count;
        
    }
}