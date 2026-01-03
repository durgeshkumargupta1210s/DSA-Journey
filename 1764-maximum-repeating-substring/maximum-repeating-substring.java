class Solution {
    public int maxRepeating(String str, String word) {
        int count=0;
        String temp=word;
        while(str.contains(temp)){
            count++;
            temp+=word;
        }
        return count;
        
    }
}