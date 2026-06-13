class Solution {
    public boolean halvesAreAlike(String s) {
        String vowel = "aeiou";
        int len = s.length();

        String first = s.substring(0, len / 2).toLowerCase();
        String second = s.substring(len / 2).toLowerCase();

        int vc1 = 0;
        int vc2 = 0;

        for (int i = 0; i < first.length(); i++) {
            if (vowel.contains(String.valueOf(first.charAt(i)))) {
                vc1++;
            }
        }

        for (int i = 0; i < second.length(); i++) {
            if (vowel.contains(String.valueOf(second.charAt(i)))) {
                vc2++;
            }
        }

        return vc1 == vc2;
    }
}