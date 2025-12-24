import java.util.*;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        
        for (int day = 0; day < N; day++) {
            String state = Arrays.toString(cells);
            
            if (seen.containsKey(state)) {
                int cycleLen = day - seen.get(state);
                int remaining = (N - day) % cycleLen;
                
                for (int i = 0; i < remaining; i++) {
                    cells = nextState(cells);
                }
                return cells;
            }
            
            seen.put(state, day);
            cells = nextState(cells);
        }
        
        return cells;
    }
    
    private int[] nextState(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            next[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return next;
    }
}
