class Solution {
    public boolean isPathCrossing(String path) {
      return path_crossing(path);  
    }
    private static boolean path_crossing(String path) {
		int x = 0, y = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(x + "," + y);
        for (char direction : path.toCharArray()) {
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            String currentPos = x + "," + y;
            if (visited.contains(currentPos)) {
                return true;
            }
            visited.add(currentPos);
        }
		return false;
	}

}