class Solution {
    public int compress(char[] chars) {

        // i -> pointer where we write the compressed result
        int i = 0;

        // n -> length of the input character array
        int n = chars.length;

        // j -> pointer used to traverse the array
        int j = 0;

        // Traverse the entire character array
        while (j < n) {

            // count -> stores how many times the current character repeats
            int count = 0;

            // Count consecutive occurrences of the same character
            // Example: "aaa" → count becomes 3
            while (j + count < n && chars[j + count] == chars[j]) {
                count++;
            }

            // Write the current character into the compressed position
            chars[i++] = chars[j];

            // If the character appears more than once,
            // write its count after the character
            if (count > 1) {

                // Convert count to string and iterate through each digit
                // Example: count = 12 → "12" → ['1','2']
                for (char ch : Integer.toString(count).toCharArray()) {

                    // Write each digit into the array
                    chars[i++] = ch;
                }
            }

            // Move j to the next new character group
            // Example: after "aaa" → jump 3 positions
            j += count;
        }

        // Return the new length of the compressed array
        return i;
    }
}