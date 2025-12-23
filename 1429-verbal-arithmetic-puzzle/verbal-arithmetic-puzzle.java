class Solution {

    Map<Character, Integer> map = new HashMap<>();
    boolean[] used = new boolean[10];
    String[] words;
    String result;

    public boolean isSolvable(String[] words, String result) {
    this.words = words;
    this.result = result;

    Set<Character> set = new HashSet<>();
    for (String w : words)
        for (char c : w.toCharArray()) set.add(c);
    for (char c : result.toCharArray()) set.add(c);

    if (set.size() > 10) return false;

    int maxLen = 0;
    for (String w : words) {
        maxLen = Math.max(maxLen, w.length());
    }

   
    if (result.length() < maxLen || result.length() > maxLen + 1) {
        return false;
    }

    return dfs(0, 0, 0);
}


    
    private boolean dfs(int col, int row, int carry) {

        if (col == result.length()) {
            return carry == 0;
        }

      
        if (row == words.length) {
            char resChar = getChar(result, col);
            int sum = carry;

            if (map.containsKey(resChar)) {
                if (map.get(resChar) != sum % 10) return false;
                return dfs(col + 1, 0, sum / 10);
            } else {
                int digit = sum % 10;
                if (used[digit]) return false;
                if (digit == 0 && isLeading(resChar)) return false;

                used[digit] = true;
                map.put(resChar, digit);

                if (dfs(col + 1, 0, sum / 10)) return true;

                used[digit] = false;
                map.remove(resChar);
                return false;
            }
        }

       
        if (col >= words[row].length()) {
            return dfs(col, row + 1, carry);
        }

        char ch = getChar(words[row], col);

        if (map.containsKey(ch)) {
            return dfs(col, row + 1, carry + map.get(ch));
        }

        for (int d = 0; d <= 9; d++) {
            if (used[d]) continue;
            if (d == 0 && isLeading(ch)) continue;

            used[d] = true;
            map.put(ch, d);

            if (dfs(col, row + 1, carry + d)) return true;

            used[d] = false;
            map.remove(ch);
        }

        return false;
    }

    private char getChar(String s, int col) {
        return s.charAt(s.length() - 1 - col);
    }

    private boolean isLeading(char c) {
        for (String w : words)
            if (w.length() > 1 && w.charAt(0) == c) return true;
        return result.length() > 1 && result.charAt(0) == c;
    }
}
