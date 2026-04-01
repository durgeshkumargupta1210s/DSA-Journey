import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int n = positions.length;

        // Step 1: Create robot array -> {position, health, direction, index}
        int[][] robots = new int[n][4];
        for(int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i); // store as int (char)
            robots[i][3] = i; // original index
        }

        // Step 2: Sort robots by position
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        // Step 3: Stack to store indices of robots moving right
        Stack<Integer> stack = new Stack<>();

        // Step 4: Traverse robots
        for(int i = 0; i < n; i++) {

            // If direction is 'R', push index
            if(robots[i][2] == 'R') {
                stack.push(i);
            } 
            else { // direction is 'L'

                // Collision with stack top (R robots)
                while(!stack.isEmpty() && robots[i][1] > 0) {

                    int top = stack.peek();

                    // If right robot already dead, remove
                    if(robots[top][1] == 0) {
                        stack.pop();
                        continue;
                    }

                    // Case 1: Equal health → both die
                    if(robots[top][1] == robots[i][1]) {
                        robots[top][1] = 0;
                        robots[i][1] = 0;
                        stack.pop();
                        break;
                    }
                    // Case 2: Right robot stronger
                    else if(robots[top][1] > robots[i][1]) {
                        robots[top][1]--;
                        robots[i][1] = 0;
                        break;
                    }
                    // Case 3: Left robot stronger
                    else {
                        robots[i][1]--;
                        robots[top][1] = 0;
                        stack.pop();
                    }
                }
            }
        }

        // Step 5: Collect survivors in original order
        int[] result = new int[n];
        for(int[] robot : robots) {
            result[robot[3]] = robot[1];
        }

        // Step 6: Prepare answer list
        List<Integer> ans = new ArrayList<>();
        for(int val : result) {
            if(val > 0) {
                ans.add(val);
            }
        }

        return ans;
    }
}