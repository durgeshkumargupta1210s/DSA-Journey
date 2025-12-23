class Solution {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        
        sb.append('#');

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            
            if (word.length() == 0) continue;

            if (i == 0) {
                sb.append(word);
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
        }
        StringBuilder clean = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (c == '#' || Character.isLetter(c)) {
                clean.append(c);
            }
            if (clean.length() == 100) break;
        }

        return clean.toString();
    }
}
