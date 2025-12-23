class Solution {
    public int countCollisions(String directions) {
        int count=0;
        int i=0;
        int n=directions.length();
        int j=n-1;

        while( i< n && directions.charAt(i)=='L'){
            i++;
        }
        while( j >=0 && directions.charAt(j)=='R'){
            j--;
        }

        for(int k=i; k<=j; k++){
            if(directions.charAt(k)!='S'){
                count++;
            }
        }
        return count;

        
    }
}