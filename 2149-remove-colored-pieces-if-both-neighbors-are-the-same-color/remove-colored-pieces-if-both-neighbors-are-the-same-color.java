class Solution {
    public boolean winnerOfGame(String colors) {
        int aCount=0;
        int bCount=0;
        char[] ch=colors.toCharArray();

        for(int i=1; i<colors.length()-1; i++){
          if(ch[i-1]=='A' && ch[i]=='A' && ch[i+1]=='A'){
            aCount++;
          }

          if(ch[i-1]=='B' && ch[i]=='B' && ch[i+1]=='B'){
            bCount++;
          }
          
        }
        return aCount>bCount;
        
    }
}