class Solution {
    public boolean canConvertString(String s, String t, int k) {
      return   ConvertString(s,t,k);
    }
    private static boolean ConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] shiftCount = new int[26]; 

        for (int i = 0; i < s.length(); i++) {
            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (shift > 0) {
                shiftCount[shift]++;            }
        }
        for (int shift = 1; shift < 26; shift++) {
            int maxMovesNeeded = shift + (shiftCount[shift] - 1) * 26;
            if (maxMovesNeeded > k) {
                return false;
            }
        }

        return true;
    }
}