class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // If concatenations differ, no common divisor string exists
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
