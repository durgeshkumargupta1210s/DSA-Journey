class Solution {
    public int countCharacters(String[] words, String chars) {
        return count_char(words,chars);
    }
    private static int count_char(String[] words, String chars) {
        int sum = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            if (canFormWord(word, new HashMap<>(charCount))) {
                sum += word.length();
            }
        }

        return sum;
    }

    private static boolean canFormWord(String word, HashMap<Character, Integer> charCount) {
        for (char c : word.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }

}