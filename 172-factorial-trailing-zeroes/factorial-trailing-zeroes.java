class Solution {
    public int trailingZeroes(int n) {
        return trailing_zeros(n);
    }

    private static int trailing_zeros(int n) {
        int sum = 0; 
        int divisor = 5;
        while (n / divisor > 0) {
            sum += n / divisor;
            divisor *= 5;
        }
        
        return sum;
    }
}