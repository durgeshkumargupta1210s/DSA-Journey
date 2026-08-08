class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                String word = s.substring(i, j);

                if (isvalid(word)) {
                    ans = Math.max(ans, word.length());
                }
            }
        }

        return ans;
    }

    public static boolean isvalid(String s) {

        int zero = 0;
        int one = 0;

        
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }

        
        if (zero != one) {
            return false;
        }

        boolean foundOne = false;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                foundOne = true;
            } 
            else if (foundOne) {
                return false;
            }
        }

        return true;
    }
}