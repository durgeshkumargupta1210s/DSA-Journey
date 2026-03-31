class Solution {

    public String generateString(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // Result length = n + m - 1
        char[] res = new char[n + m - 1];

        // Tracks indices that are fixed due to 'T'
        boolean[] locked = new boolean[n + m - 1];

        // Step 1: Initialize with 'a' (smallest lexicographically)
        for (int i = 0; i < res.length; i++) {
            res[i] = 'a';
        }

        // Step 2: Apply all 'T' constraints (HARD constraints)
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {

                for (int j = 0; j < m; j++) {
                    int idx = i + j;

                    // If already assigned and conflicting → impossible
                    if (res[idx] != 'a' && res[idx] != str2.charAt(j)) {
                        return "";
                    }

                    // Assign value and lock this index
                    res[idx] = str2.charAt(j);
                    locked[idx] = true;
                }
            }
        }

        // Step 3: Handle 'F' constraints (SOFT constraints)
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;

                // Check if substring equals str2
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If it matches, we must break it
                if (match) {

                    boolean broken = false;

                    // Try modifying from right to left
                    // (to preserve lexicographically smallest result)
                    for (int j = m - 1; j >= 0 && !broken; j--) {

                        int idx = i + j;

                        // ❗ Skip locked indices (cannot modify 'T' enforced positions)
                        if (locked[idx]) continue;

                        char original = res[idx];

                        // Try replacing with smallest possible valid character
                        for (char c = 'a'; c <= 'z'; c++) {

                            if (c == original) continue;

                            res[idx] = c;

                            // After change, check if current window is broken
                            boolean stillMatch = true;
                            for (int k = 0; k < m; k++) {
                                if (res[i + k] != str2.charAt(k)) {
                                    stillMatch = false;
                                    break;
                                }
                            }

                            if (!stillMatch) {
                                broken = true;
                                break;
                            }
                        }

                        // Revert if not successful
                        if (!broken) {
                            res[idx] = original;
                        }
                    }

                    // If no way to break → impossible
                    if (!broken) return "";
                }
            }
        }

        // Step 4: Final validation (safety check)
        for (int i = 0; i < n; i++) {

            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (res[i + j] != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (str1.charAt(i) == 'T' && !match) return "";
            if (str1.charAt(i) == 'F' && match) return "";
        }

        return new String(res);
    }
}