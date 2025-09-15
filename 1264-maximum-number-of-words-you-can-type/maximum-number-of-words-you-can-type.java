public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Convert broken letters to a set for fast lookup
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }

        // Split the text into words
        String[] words = text.split(" ");
        int count = 0;

        // Check each word
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }

        return count;
    }
}
