import java.util.*;

class Solution {
    int answer;

    public int minSessions(int[] tasks, int sessionTime) {
        // Sort tasks in descending order
        Arrays.sort(tasks);
        reverse(tasks);

        answer = tasks.length; // worst case: each task in its own session
        List<Integer> sessions = new ArrayList<>();

        backtrack(0, tasks, sessions, sessionTime);
        return answer;
    }

    private void backtrack(int idx, int[] tasks, List<Integer> sessions, int sessionTime) {
        // All tasks placed
        if (idx == tasks.length) {
            answer = Math.min(answer, sessions.size());
            return;
        }

        // Prune if already worse than best
        if (sessions.size() >= answer) return;

        int currTask = tasks[idx];

        for (int i = 0; i < sessions.size(); i++) {
            // Try placing task in existing session
            if (sessions.get(i) + currTask <= sessionTime) {

                sessions.set(i, sessions.get(i) + currTask);
                backtrack(idx + 1, tasks, sessions, sessionTime);
                sessions.set(i, sessions.get(i) - currTask);

                // Pruning: avoid symmetric placements
                if (sessions.get(i) == 0) break;
            }
        }

        // Start a new session
        sessions.add(currTask);
        backtrack(idx + 1, tasks, sessions, sessionTime);
        sessions.remove(sessions.size() - 1);
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
