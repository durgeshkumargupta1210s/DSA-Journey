class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);   // lexicographical sort
        Set<String> set = new HashSet<>();
        set.add("");           // base case

        String answer = "";

        for (String word : words) {
            String prefix = word.substring(0, word.length() - 1);

            if (set.contains(prefix)) {
                set.add(word);

                if (word.length() > answer.length()) {
                    answer = word;
                }
            }
        }

        return answer;
    }
}
