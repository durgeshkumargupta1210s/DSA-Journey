class Solution {
    public int myAtoi(String s) {

        // Get length of the string
        int n = s.length();

        // Pointer to traverse the string
        int i = 0;

        // Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Determine the sign of the number
        // Default sign is positive
        int sign = 1;

        // If '+' or '-' is present, update sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;  // Negative number
            }
            i++; // Move to next character
        }

        // Step 3: Convert digits to integer
        int result = 0;

        // Process characters while they are digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert character digit to integer value
            int digit = s.charAt(i) - '0';

            // Step 4: Check for overflow before multiplying by 10
            // If result exceeds Integer.MAX_VALUE boundary
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Update result by shifting digits left and adding current digit
            result = result * 10 + digit;

            // Move to next character
            i++;
        }

        // Step 5: Apply the sign and return final result
        return result * sign;
    }
}