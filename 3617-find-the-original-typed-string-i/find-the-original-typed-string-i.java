class Solution {
    public int possibleStringCount(String word) {
        int count = 1;

        for (int i = 0; i < word.length()-1; i++) {
            char ch1 = word.charAt(i);
            char ch2 = word.charAt(i+1);

            if(ch1==ch2){
                count++;
            }
        }

        return count;
    }
}
