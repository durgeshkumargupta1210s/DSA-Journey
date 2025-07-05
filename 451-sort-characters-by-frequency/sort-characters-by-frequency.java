import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Put entries into a list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort the list by frequency (descending)
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
