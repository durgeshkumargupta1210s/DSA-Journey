class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        return self_divide(left, right);
    }

    public static List<Integer> self_divide(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (is_self_dividing(num)) {
                result.add(num);
            }
        }
        return result;
    }

    private static boolean is_self_dividing(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}