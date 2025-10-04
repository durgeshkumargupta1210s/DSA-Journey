import java.util.HashMap;

class Solution {
    public int numRabbits(int[] arr) {
        // Create a HashMap to store the frequency of each rabbit's answer
        // Key   → the number reported by the rabbit (x)
        // Value → how many rabbits gave this answer
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the occurrences of each answer
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int count = 0;  // This variable will store the total number of rabbits

        // Loop through each unique answer in the map
        for (int ele : map.keySet()) {
            // If a rabbit says 'ele', then there are (ele + 1) rabbits of that color
            int size = ele + 1;

            // Number of rabbits that gave this answer
            int freq = map.get(ele);

            // Calculate how many groups are needed to accommodate all rabbits
            // Example: If 5 rabbits say '2' → size = 3 (2+1), groups = ceil(5/3) = 2 groups
            int groups = (int) Math.ceil(freq / (double) size);

            // Total rabbits for this answer = groups × size
            count += (groups * size);
        }

        // Return the minimum number of rabbits in the forest
        return count;
    }
}
