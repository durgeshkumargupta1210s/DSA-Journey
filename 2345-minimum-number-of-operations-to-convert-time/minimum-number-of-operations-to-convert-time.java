class Solution {
    public int convertTime(String current, String correct) {
        int currentMinutes = toMinutes(current);
        int correctMinutes = toMinutes(correct);
        int diff = correctMinutes - currentMinutes;

        int operations = 0;
        int[] steps = {60, 15, 5, 1};

        for (int step : steps) {
            operations += diff / step;
            diff %= step;
        }

        return operations;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
