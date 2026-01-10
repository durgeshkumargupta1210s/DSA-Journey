class Solution {
    public int numberOfSpecialChars(String word) {
    
     // Stores the last index where each lowercase character appears
        // Index 0 → 'a', 1 → 'b', ..., 25 → 'z'
        int[] lastLowerCase = new int[26];

        // Stores the first index where each uppercase character appears
        // Index 0 → 'A', 1 → 'B', ..., 25 → 'Z'
        int[] firstUpperCase = new int[26];

        int count = 0;

        // Initialize:
        // - lastLowerCase with -1 (means lowercase letter not seen)
        // - firstUpperCase with Integer.MAX_VALUE (means uppercase letter not seen)
        Arrays.fill(firstUpperCase, Integer.MAX_VALUE);
        Arrays.fill(lastLowerCase, -1);

        // Traverse the string to record positions
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            // If character is lowercase, update its last occurrence
            if (Character.isLowerCase(ch)) {
                lastLowerCase[ch - 'a'] = i;
            }
            // Otherwise, character is uppercase
            // Update the first occurrence using minimum index
            else {
                firstUpperCase[ch - 'A'] =
                    Math.min(i, firstUpperCase[ch - 'A']);
            }
        }

        // Check for "special characters"
        // A character is special if:
        // - It appears in lowercase
        // - It appears in uppercase
        
        for (int i = 0; i < 26; i++) {

            if (firstUpperCase[i] != Integer.MAX_VALUE &&
                lastLowerCase[i] != -1)
                {

                count++;
            }
        }

        return count;
    }
}