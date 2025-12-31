class Solution {

    // Pair class to store the current word and the number of steps taken
    static class Pair {
        String word;
        int step;

        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Store words in a HashSet for O(1) lookup
        Set<String> set = new HashSet<>();
        for (String w : wordList) {
            set.add(w);
        }

        // If endWord is not present, transformation is impossible
        if (!set.contains(endWord)) {
            return 0;
        }

        // BFS queue storing (word, level)
        Queue<Pair> q = new LinkedList<>();

        // Start BFS from beginWord
        q.add(new Pair(beginWord, 1));

        // Mark beginWord as visited
        set.remove(beginWord);

        while (!q.isEmpty()) {

            Pair current = q.poll();
            String str = current.word;
            int level = current.step;

            // If endWord is reached, return the level
            if (str.equals(endWord)) {
                return level;
            }

            char[] chars = str.toCharArray();

            // Try changing each character
            for (int i = 0; i < chars.length; i++) {

                char original = chars[i];

                // Replace with all possible letters
                for (char c = 'a'; c <= 'z'; c++) {

                    chars[i] = c;
                    String nextWord = String.valueOf(chars);

                    // If valid unvisited transformation exists
                    if (set.contains(nextWord)) {
                        q.add(new Pair(nextWord, level + 1));
                        set.remove(nextWord); // mark as visited
                    }
                }

                // Restore original character
                chars[i] = original;
            }
        }

        // No transformation sequence found
        return 0;
    }
}
