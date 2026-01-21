class Solution {

    // This method checks whether a valid original binary array can exist
    // such that the XOR of adjacent elements produces the given 'derived' array
    public boolean doesValidArrayExist(int[] derived) {

        // Variable to store cumulative XOR of all elements in 'derived'
        int xor = 0;

        // Iterate through the derived array
        for (int i = 0; i < derived.length; i++) {

            // XOR each element with the running result
            // XOR has the property that a ^ a = 0 and a ^ 0 = a
            xor ^= derived[i];
        }

        // If the total XOR is 0, a valid original array exists
        // Otherwise, it is impossible to construct such an array
        return xor == 0;
    }
}
