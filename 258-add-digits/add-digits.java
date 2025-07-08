class Solution {
    public int addDigits(int num) {
     return add_digit(num);   
    }
    private static int add_digit(int num) {
        if (num == 0) {
            return 0;
        }
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}