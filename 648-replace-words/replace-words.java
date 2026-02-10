class Solution {

    // Trie data structure to store dictionary roots
    static class Trie {

        // Node class representing each character
        class Node {

            char data;  // character stored in this node

            // HashMap to store children nodes
            HashMap<Character, Node> child;

            // Stores complete word if this node is terminal
            String isTerminal;

            public Node(char data) {
                this.data = data;
                this.child = new HashMap<>();
                this.isTerminal = null;
            }
        }

        // Root node (dummy node)
        private Node root = new Node('*');


        // Insert word into Trie
        // Time Complexity: O(L)
        public void insert(String word) {

            Node curr = root;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                // If character already exists, move to child
                if (curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                }
                else {
                    // Else create new node
                    Node nn = new Node(ch);
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }

            // Mark end of word by storing root word
            curr.isTerminal = word;
        }


        // Search shortest prefix root in Trie
        // Time Complexity: O(L)
        public String search(String word) {

            Node curr = root;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                // If path exists in Trie
                if (curr.child.containsKey(ch)) {

                    curr = curr.child.get(ch);

                    // If terminal found, return shortest root
                    if (curr.isTerminal != null) {
                        return curr.isTerminal;
                    }
                }
                else {
                    // No prefix found → return original word
                    return word;
                }
            }

            // No root found → return original word
            return word;
        }
    }



    // Main function
    // Time Complexity: O((N+M)*L)
    public String replaceWords(List<String> dictionary, String sentence) {

        // Create Trie
        Trie trie = new Trie();


        // Insert all dictionary words into Trie
        for (String word : dictionary) {
            trie.insert(word);
        }


        // Split sentence into words
        String[] words = sentence.split(" ");


        // Store result
        StringBuilder result = new StringBuilder();


        // Process each word
        for (String word : words) {

            // Replace with shortest root if exists
            result.append(trie.search(word)).append(" ");
        }


        // Remove trailing space and return
        return result.toString().trim();
    }
}
