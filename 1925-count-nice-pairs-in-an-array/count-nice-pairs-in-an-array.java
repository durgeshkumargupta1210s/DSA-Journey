import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {

        Map<Integer, Long> freq = new HashMap<>();

        for (int num : nums) {
            int rev = reverse(num);
            int key = num - rev;
            freq.put(key, freq.getOrDefault(key, 0L) + 1);
        }

        long result = 0;

        for (long count : freq.values()) {
            result = (result + (count * (count - 1) / 2) % MOD) % MOD;
        }

        return (int) result;
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
}
