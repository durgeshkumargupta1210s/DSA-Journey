class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count=0;
        String vowel="aeiou";
        for(int i=left; i<=right; i++){
            String s=words[i];
            if(vowel.contains(s.charAt(0)+"") && vowel.contains(s.charAt(s.length()-1)+"") ){
                count++;
            }
        }
        return count;
    }
}