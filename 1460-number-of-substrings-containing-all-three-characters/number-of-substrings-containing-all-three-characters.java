class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // counts of 'a','b','c'
        int left = 0;
        int total = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            // shrink window until it does not contain all 3
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // all substrings ending at right and starting before 'left' are valid
            total += left;
        }

        return total;
    }
}
