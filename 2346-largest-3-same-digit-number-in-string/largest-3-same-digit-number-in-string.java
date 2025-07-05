class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        
        for (int i = 0; i <= num.length() - 3; i++) {
            char a = num.charAt(i);
            char b = num.charAt(i + 1);
            char c = num.charAt(i + 2);

            if (a == b && b == c) {
                String good = num.substring(i, i + 3);
                if (max.isEmpty() || good.compareTo(max) > 0) {
                    max = good;
                }
            }
        }
        
        return max;
    }
}
