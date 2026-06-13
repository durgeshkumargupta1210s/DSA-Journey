class Solution {
    public boolean squareIsWhite(String coordinates) {
        char ch=coordinates.charAt(0);
        int digit=coordinates.charAt(1)-'0';

        if((ch=='a' || ch =='c'|| ch=='e' || ch=='g') && digit%2==1){
            return false;
        }
        else if((ch=='a' || ch =='c'|| ch=='e' || ch=='g') && digit%2==0){
            return true;
        }
        else if((ch=='b' || ch =='d'|| ch=='f' || ch=='h') && digit%2==0){
             return false;
        }
        return true;


        
    }
}