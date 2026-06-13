class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String str = "zyxwvutsrqponmlkjihgfedcba";
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int val = ch - 'a';
                sum += weights[val];
            }

            sum = sum % 26;
            sb.append(str.charAt(sum));  
        }

        return sb.toString();
    }
}