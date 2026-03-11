class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Set to store unique characters in the current window
        Set<Character> set = new HashSet<>();

        // si (start index) represents the start of the sliding window
        int si = 0;

        // maxlen stores the length of the longest substring found so far
        int maxlen = 0;

        // ei (end index) expands the sliding window
        for(int ei = 0; ei < s.length(); ei++){

            // Current character at the end of the window
            char ch = s.charAt(ei);

            // If the character already exists in the set,
            // shrink the window from the start until the duplicate is removed
            while(set.contains(ch)){
                set.remove(s.charAt(si)); // remove the starting character
                si++;                     // move start index forward
            }

            // Add the current character to the set
            set.add(ch);

            // Update the maximum length of substring without repeating characters
            maxlen = Math.max(maxlen, ei - si + 1);
        }

        // Return the maximum length found
        return maxlen;
    }
}