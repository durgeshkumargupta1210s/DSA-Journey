class Solution {
    public int getLucky(String s, int k) {

        StringBuilder sb = new StringBuilder();

        // Step 1: Convert characters to numbers
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a' + 1;
            sb.append(value);
        }

        // Step 2: Repeat digit sum k times
        String num = sb.toString();

        for (int i = 0; i < k; i++) {
            int sum = 0;

            for (int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }

            num = String.valueOf(sum);
        }

        return Integer.parseInt(num);
    }
}
