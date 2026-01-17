class Solution {
    public boolean canAliceWin(int[] nums) {

        int sumSingle = 0;
        int sumDouble = 0;

        for (int num : nums) {
            if (num < 10) {
                sumSingle += num;
            } else {
                sumDouble += num;
            }
        }

        return sumSingle != sumDouble;
    }
}
