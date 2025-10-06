class Solution {
    // Global variable to keep track of the total number of valid arrangements
    int count = 0;

    /**
     * Main function to count the number of beautiful arrangements.
     * @param n the number from 1 to n to arrange
     * @return the total number of valid arrangements
     */
    public int countArrangement(int n) {  
        // visited[i] will be true if number (i+1) is already used in the current arrangement
        boolean[] visited = new boolean[n];

        // Start generating arrangements from position 1
        GeneratePermutation(n, 1, visited);

        // Return the total count of valid arrangements found
        return count; 
    }
    
    /**
     * Recursive backtracking function to generate valid arrangements.
     * @param n total number of elements to arrange
     * @param position current position being filled (1-indexed)
     * @param visited boolean array to track which numbers are already used
     */
    public void GeneratePermutation(int n, int position, boolean[] visited) {
        // Base case: if all positions have been filled (position > n)
        // it means we found a valid arrangement
        if (position > n) {
            count++;
            return;
        }
        
        // Try placing each number (1 to n) at the current position
        for (int i = 1; i <= n; i++) {
            // Check if number 'i' is not already used
            // AND it satisfies the beautiful arrangement condition:
            // (number divisible by position OR position divisible by number)
            if (!visited[i - 1] && (i % position == 0 || position % i == 0)) {

                // Choose the number 'i' for this position
                visited[i - 1] = true;

                // Recurse for the next position
                GeneratePermutation(n, position + 1, visited);

                // Backtrack: unmark number 'i' to use it in other permutations
                visited[i - 1] = false;
            }
        }
    }
}
