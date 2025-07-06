class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        return repeatedseq(s);
    }
     private static List<String> repeatedseq(String s) {
        // HashSet to store sequences of length 10
        HashSet<String> set = new HashSet<>();
        // HashSet to store repeated sequences
        HashSet<String> result = new HashSet<>();
        
        int si = 0; // Start index
        
        // Loop through the string to extract substrings of length 10
        while (si + 10 <= s.length()) { // Ensure we only extract valid substrings
            String str = s.substring(si, si + 10);
            if (set.contains(str)) {
                result.add(str);
            }
            set.add(str);
            si++;
        }
        
        // Convert HashSet to ArrayList and return
        return new ArrayList<>(result);
    }
}