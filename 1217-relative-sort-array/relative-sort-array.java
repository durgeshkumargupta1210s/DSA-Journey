class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        // Step 1: Create a frequency map of elements in arr1
        // Key = element, Value = frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Result array to store final sorted order
        int[] result = new int[arr1.length];
        int index = 0;

        // Step 2: Place elements in result based on order of arr2
        for (int num : arr2) {

            // Get frequency of current number from arr2
            int freq = map.get(num);

            // Add 'num' freq times into result
            while (freq-- > 0) {
                result[index++] = num;
            }

            // Remove element from map after processing
            // so that only remaining elements are left
            map.remove(num);
        }

        // Step 3: Collect remaining elements (not present in arr2)
        List<Integer> remaining = new ArrayList<>();

        for (int key : map.keySet()) {

            int freq = map.get(key);

            // Add each remaining element based on its frequency
            while (freq-- > 0) {
                remaining.add(key);
            }
        }

        // Step 4: Sort remaining elements in ascending order
        Collections.sort(remaining);

        // Step 5: Append remaining elements to result
        for (int num : remaining) {
            result[index++] = num;
        }

        return result;
    }
}