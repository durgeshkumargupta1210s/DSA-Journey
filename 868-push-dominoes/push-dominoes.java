class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();

        int prev = -1;          
        char prevForce = 'L'; 

        for (int i = 0; i <= n; i++) {
            char currForce = (i == n) ? 'R' : arr[i];

            if (currForce == '.') continue;

            if (prevForce == currForce) {
                for (int k = prev + 1; k < i; k++) {
                    arr[k] = currForce;
                }
            } else if (prevForce == 'R' && currForce == 'L') {
                
                int l = prev + 1;
                int r = i - 1;
                while (l < r) {
                    arr[l++] = 'R';
                    arr[r--] = 'L';
                }
            }

            prev = i;
            prevForce = currForce;
        }

        return new String(arr);
    }
}
