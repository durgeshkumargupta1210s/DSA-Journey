class Solution {

    // Stores words for numbers from 0 to 19
    private final String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    // Stores words for multiples of 10 (20, 30, ..., 90)
    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Stores place values (thousands system)
    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        // Edge case: if number is 0
        if (num == 0) return "Zero";

        int i = 0;                 // Index for thousands array
        String result = "";        // Final result string

        // Process number in chunks of 3 digits (e.g., 1234567 → 567, 234, 1)
        while (num > 0) {

            // If current 3-digit chunk is not zero
            if (num % 1000 != 0) {

                // Convert chunk to words and append its place value
                result = helper(num % 1000)   // Convert 3-digit number
                       + thousands[i] + " "   // Add Thousand/Million/etc.
                       + result;              // Append to final result
            }

            // Remove last 3 digits
            num /= 1000;

            // Move to next place value (Thousand → Million → Billion)
            i++;
        }

        // Remove extra spaces and return final answer
        return result.trim();
    }

    // Helper function to convert numbers less than 1000 into words
    private String helper(int num) {

        // Base case: if number is 0, return empty string
        if (num == 0) return "";

        // If number is less than 20, directly map from array
        else if (num < 20)
            return below20[num] + " ";

        // If number is less than 100
        else if (num < 100)
            // Example: 45 → Forty + Five
            return tens[num / 10] + " " + helper(num % 10);

        // If number is 100 or more
        else
            // Example: 345 → Three Hundred + Forty Five
            return below20[num / 100] + " Hundred " + helper(num % 100);
    }
}