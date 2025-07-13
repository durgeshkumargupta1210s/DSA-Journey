class Solution {
    public int dayOfYear(String date) {
        String y = date.substring(0, 4);
        String m = date.substring(5, 7);
        String d = date.substring(8, 10);

        int year = Integer.parseInt(y);
        int month = Integer.parseInt(m);
        int day = Integer.parseInt(d);

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 
                              31, 31, 30, 31, 30, 31 };

        if ((year % 4 == 0 && year % 100 != 0) || 
             (year % 400 == 0)) {
            daysInMonth[1] = 29;
        }

        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        return totalDays;
    }
}
