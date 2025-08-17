import java.util.ArrayList;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        
        ArrayList<String> allWords = new ArrayList<>();
        ArrayList<String> uncommonWords = new ArrayList<>();
        

        for (String word : words1) {
            allWords.add(word);
        }
        
        for (String word : words2) {
            allWords.add(word);
        }
        
        
        for (String word : allWords) {
            int count = 0;
            for (String w : allWords) {
                if (word.equals(w)) {
                    count++;
                }
            }
            // If the word appears exactly once, it's an uncommon word
            if (count == 1) {
                uncommonWords.add(word);
            }
        }
        
        // Convert the list of uncommon words to an array and return
        return uncommonWords.toArray(new String[0]);
    }
}