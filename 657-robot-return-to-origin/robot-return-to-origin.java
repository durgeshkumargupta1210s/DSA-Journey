class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        
        // Iterate through the moves string
        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;  
            } else if (move == 'L') {
                x--;  
            } else if (move == 'R') {
                x++;
            }
        }
        
       
        return x == 0 && y == 0;
    }
}