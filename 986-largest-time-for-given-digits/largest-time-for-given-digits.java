class Solution {

    int maxTime = -1;

    public String largestTimeFromDigits(int[] arr) {
        boolean[] used = new boolean[4];
        backtrack(arr, used, new int[4], 0);

        if (maxTime == -1) {
            return "";
        }

        int hour = maxTime / 60;
        int minute = maxTime % 60;

        return String.format("%02d:%02d", hour, minute);
    }

    private void backtrack(int[] arr, boolean[] used, int[] temp, int index) {
        if (index == 4) {
            int hour = temp[0] * 10 + temp[1];
            int minute = temp[2] * 10 + temp[3];

            if (hour < 24 && minute < 60) {
                int totalMinutes = hour * 60 + minute;
                maxTime = Math.max(maxTime, totalMinutes);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (used[i]) continue;

            used[i] = true;
            temp[index] = arr[i];
            backtrack(arr, used, temp, index + 1);
            used[i] = false;
        }
    }
}
