class Solution {
    public long kMirror(int k, int n) {
        int l = 1;
        long sum = 0L;

        while (n > 0) {
            int half = (l + 1) / 2;
            int min = (int) Math.pow(10, half - 1);
            int max = (int) Math.pow(10, half) - 1;

            for (int i = min; i <= max; i++) {
                long num1 = (l % 2 == 0) ? evendecimalPalindrome(i) : odddecimalPalindrome(i);

                String k_baseValue = findKBase(num1, k);
                if (isPalindrome(k_baseValue)) {
                    sum += num1;
                    n--;
                    if (n == 0) break;
                }
            }
            l++;
        }
        return sum;
    }

    public static String findKBase(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public long evendecimalPalindrome(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        String str1 = str + sb.reverse().toString();
        return Long.parseLong(str1);
    }

    public long odddecimalPalindrome(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        String str1 = str + sb.reverse().toString().substring(1);
        return Long.parseLong(str1);
    }
}
