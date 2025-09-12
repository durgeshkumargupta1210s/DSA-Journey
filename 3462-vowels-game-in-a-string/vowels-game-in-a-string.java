class Solution {
    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                vowels++;
            }
        }
        return vowels > 0;  // Alice wins if there is at least one vowel
    }
}
