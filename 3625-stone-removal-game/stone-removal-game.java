class Solution {
    public boolean canAliceWin(int n) {
        int count = 10;
        boolean alice = true;
        while(n>=count){
            n-=count;
            count--;
            alice=!alice;
        }
    return !alice;
    }
}