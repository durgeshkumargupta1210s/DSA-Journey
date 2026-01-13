class Solution {
    public int countPoints(String rings) {
        boolean [] blue=new boolean[10];
        boolean [] red=new boolean[10];
        boolean [] green=new boolean[10];

        for(int i=0; i<rings.length()-1; i++){
            char ch=rings.charAt(i);
            char digit=rings.charAt(i+1);
            if(ch=='B'){
                blue[digit-'0']=true;
            }
            if(ch=='G'){
                green[digit-'0']=true;
            }
            if(ch=='R'){
                red[digit-'0']=true;
            }
        }
        int count=0;

        for(int i=0; i<10; i++){
            if(blue[i] && green[i] && red[i]){
                count++;
            }
        }
        return count;
        
    }
}