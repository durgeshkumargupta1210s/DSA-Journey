class Solution {

    public int minimumBuckets(String hamsters) {

        // Length of the input string
        int n = hamsters.length();

        // Convert string to character array for easy modification
        char[] arr = hamsters.toCharArray();

        // Counter to store number of buckets placed
        int bucket = 0;

        // Traverse the string from left to right
        for (int i = 0; i < n; i++) {

            // Process only if the current position has a hamster
            if (arr[i] == 'H') {

                // Case 1:
                // If the left position already has a bucket,
                // then this hamster is already fed
                if (i - 1 >= 0 && arr[i - 1] == 'B') {
                    continue;
                }

                // Case 2 (Greedy choice):
                // Prefer placing a bucket on the right side if possible
                // because it may also feed the next hamster
                if (i + 1 < n && arr[i + 1] == '.') {
                    arr[i + 1] = 'B';   // Place bucket
                    bucket++;           // Increment bucket count
                }

                // Case 3:
                // If right side is not available, try placing on the left
                else if (i - 1 >= 0 && arr[i - 1] == '.') {
                    arr[i - 1] = 'B';   // Place bucket
                    bucket++;           // Increment bucket count
                }

                // Case 4:
                // If neither left nor right side is available,
                // it is impossible to feed this hamster
                else {
                    return -1;
                }
            }
        }

        // Return the minimum number of buckets placed
        return bucket;
    }
}
