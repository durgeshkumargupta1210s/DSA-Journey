class Solution {
    public int largestVariance(String s) {

        int n = s.length();
        int ans = 0;   // Stores the maximum variance found

        // Iterate over all possible ordered pairs of characters (a, b)
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {

                // Skip same character pair because variance requires two different characters
                if (a == b) {
                    continue;
                }

                int dif = 0;       // Difference: count(a) - count(b) for current substring
                int remain = 0;    // Number of remaining 'b' characters to the right

                // Count total occurrences of character 'b' in the string
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == b) {
                        remain++;
                    }
                }

                boolean hasB = false; // Checks if current substring contains at least one 'b'

                // Apply modified Kadane’s Algorithm
                for (int i = 0; i < n; i++) {
                    char ch = s.charAt(i);

                    // If character is 'a', increase difference
                    if (ch == a) {
                        dif++;
                    }

                    // If character is 'b', decrease difference
                    if (ch == b) {
                        dif--;
                        hasB = true;   // Mark that substring has at least one 'b'
                        remain--;      // Reduce remaining 'b' count
                    }

                    // Update answer only if substring has at least one 'b'
                    if (hasB) {
                        ans = Math.max(ans, dif);
                    }

                    // Reset conditions:
                    // If difference becomes negative and there are still 'b' left ahead,
                    // restarting the substring may give a better variance
                    if (dif < 0 && remain > 0) {
                        dif = 0;
                        hasB = false;
                    }
                }
            }
        }

        return ans; // Return the maximum variance found
    }
}
