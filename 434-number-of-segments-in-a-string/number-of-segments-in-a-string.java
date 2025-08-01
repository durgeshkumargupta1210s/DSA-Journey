class Solution {
    public int countSegments(String s) {
        return count(s);
    }
    public static int count(String s) {
		// TODO Auto-generated method stub
		if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] segments = s.trim().split("\\s+");
        return segments.length == 1 && segments[0].isEmpty() ? 0 : segments.length;
		
	}
}