class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        // if(s1.charAt(0)!=s2.charAt(0) && s2.charAt(0)!=s3.charAt(0)){
        //     return -1;
        // }

        if(s1.equals(s2) && s2.equals(s3)){
            return 0;
        }

        int l1=s1.length();
        int l2=s2.length();
        int l3=s3.length();

       int  min=Math.min(Math.min(l1,l2),l3);
       int count=0;

       for(int i=0; i<min; i++){
         if(s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i)){
           count++;
         }
         else{
            break;
         }
       }

       if(count==0){
        return -1;
       }
       return Math.abs(l1-count+l2-count+l3-count);
    }
}