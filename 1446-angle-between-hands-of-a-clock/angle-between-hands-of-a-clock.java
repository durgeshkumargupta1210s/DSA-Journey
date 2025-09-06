class Solution {
    public double angleClock(int hour, int minutes) {
        // Minute hand moves 6 degrees per minute
        double minuteAngle = minutes * 6;

        // Hour hand moves 30 degrees per hour + 0.5 per minute
        double hourAngle = (hour % 12) * 30 + 0.5 * minutes;

        double angle = Math.abs(minuteAngle - hourAngle);

        // Return smaller angle
        return Math.min(angle, 360 - angle);
    }
}
