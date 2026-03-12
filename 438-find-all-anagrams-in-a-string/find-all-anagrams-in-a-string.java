class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // List to store starting indices of anagrams
        List<Integer> list = new ArrayList<>();

        // map1 stores the frequency of characters in string p
        Map<Character, Integer> map1 = new HashMap<>();

        // map2 stores the frequency of characters in the current window of s
        Map<Character, Integer> map2 = new HashMap<>();

        // si represents the start index of the sliding window
        int si = 0;

        // Window size will always be equal to length of p
        int k = p.length();

        // Build frequency map for string p
        for(int i = 0; i < k; i++){
            char ch = p.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Build the first window of size k for string s
        for(int i = 0; i < k && i<s.length(); i++){
            char ch = s.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // If the first window matches the frequency map of p,
        // then index 0 is a valid anagram starting position
        if(map1.equals(map2)){
            list.add(si);
        }

        // Start sliding the window
        for(int ei = k; ei < s.length(); ei++){

            // Add the new character entering the window
            char ch = s.charAt(ei);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            // Maintain the window size equal to k
            while(ei - si + 1 > k){

                // Character leaving the window
                char ch1 = s.charAt(si);

                // Decrease its frequency
                map2.put(ch1, map2.get(ch1) - 1);

                // Remove it from map if frequency becomes zero
                if(map2.get(ch1) == 0){
                    map2.remove(ch1);
                }

                // Move the start pointer forward
                si++;
            }

            // If the frequency maps match, we found an anagram
            if(map1.equals(map2)){
                list.add(si);
            }
        }

        // Return all starting indices of anagrams
        return list;
    }
}