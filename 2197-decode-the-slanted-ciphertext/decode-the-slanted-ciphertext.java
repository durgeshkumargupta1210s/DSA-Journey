class Solution {

    public String decodeCiphertext(String encodedText, int rows) {

        // Total number of characters in encoded string
        int n = encodedText.length();

        // Number of columns in the matrix
        int colms = n / rows;

        // Pointer to traverse encodedText
        int idx = 0;

        // Step 1: Create a 2D matrix and fill it row-wise
        char[][] ch = new char[rows][colms];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                ch[i][j] = encodedText.charAt(idx++);
            }
        }

        // Step 2: Traverse diagonally starting from each column of first row
        StringBuilder result = new StringBuilder();

        for (int startCol = 0; startCol < colms; startCol++) {

            int i = 0;           // Start from first row
            int j = startCol;    // Start from current column

            // Move diagonally (down-right)
            while (i < rows && j < colms) {
                result.append(ch[i][j]);
                i++;
                j++;
            }
        }

        // Step 3: Remove trailing spaces from the decoded string
        int end = result.length() - 1;

        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        // Return final trimmed string
        return result.substring(0, end + 1);
    }
}