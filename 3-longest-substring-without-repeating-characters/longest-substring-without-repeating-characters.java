class Solution {
    public int lengthOfLongestSubstring(String s) {

        // HashMap to store frequency of characters inside the current window
        Map<Character, Integer> map = new HashMap<>();

        // si (start index) represents the start of the sliding window
        int si = 0;

        // maxlen stores the length of the longest substring found so far
        int maxlen = 0;

        // ei (end index) expands the sliding window
        for (int ei = 0; ei < s.length(); ei++) {

            // Current character at the end of the window
            char ch = s.charAt(ei);

            // Increase frequency of the current character in the map
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If frequency becomes greater than 1,
            // it means we have a duplicate character in the window
            while (map.get(ch) > 1) {

                // Character at the start of the window
                char ch1 = s.charAt(si);

                // Decrease its frequency
                map.put(ch1, map.get(ch1) - 1);

                // Remove the character from the map if its frequency becomes 0
                if (map.get(ch1) == 0) {
                    map.remove(ch1);
                }

                // Move the start pointer forward to shrink the window
                si++;
            }

            // Update the maximum length of substring with unique characters
            maxlen = Math.max(maxlen, ei - si + 1);
        }

        // Return the longest substring length without repeating characters
        return maxlen;
    }
}