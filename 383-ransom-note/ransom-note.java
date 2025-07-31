class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       return isexist(ransomNote,magazine);
    }
    public static boolean isexist(String rn, String mz) {
        // Create an array to count character frequencies for 'mz'
        int[] charCount = new int[26];

        // Count characters in 'mz'
        for (char c : mz.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if 'rn' can be constructed
        for (char c : rn.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // Not enough of character 'c' in 'mz'
            }
            charCount[c - 'a']--; // Use one instance of 'c'
        }

        return true;
    }


}