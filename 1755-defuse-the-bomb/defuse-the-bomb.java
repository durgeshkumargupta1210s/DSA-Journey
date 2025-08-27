class Solution {
    public int[] decrypt(int[] code, int k) {
        return decrupt_bomb(code,k);
    }
    private static int []  decrupt_bomb(int[] code, int k) {
		int n = code.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Wrap around using modular arithmetic
                }
            }
            else if (k < 0) {
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            result[i] = sum;
        }

        return result;
    }
}