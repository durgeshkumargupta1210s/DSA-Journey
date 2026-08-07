class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {

        int n = reward1.length;

        int ans = 0;
        Integer[] gain = new Integer[n];

        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            gain[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(gain, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            ans += gain[i];
        }

        return ans;
    }
}