import java.util.*;

class Manager {
    int userId, taskId, priority;
    Manager(int u, int t, int p) {
        userId = u;
        taskId = t;
        priority = p;
    }
}

class TaskManager {
    private PriorityQueue<Manager> pq;
    private Map<Integer, Manager> record;

    // Constructor accepts List<List<Integer>> (LeetCode format)
    public TaskManager(List<List<Integer>> tasks) {
        record = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(b.priority, a.priority); // higher priority first
            if (cmp != 0) return cmp;
            return Integer.compare(b.taskId, a.taskId);       // tie-breaker: higher taskId first
        });

        if (tasks != null) {
            for (List<Integer> task : tasks) {
                if (task == null || task.size() < 3) continue;
                Manager m = new Manager(task.get(0), task.get(1), task.get(2));
                pq.add(m);
                record.put(m.taskId, m);
            }
        }
    }

    public void add(int userId, int taskId, int priority) {
        Manager m = new Manager(userId, taskId, priority);
        pq.add(m);
        record.put(taskId, m);
    }

    public void edit(int taskId, int newPriority) {
        Manager old = record.get(taskId);
        if (old == null) return; // ignore if not present
        Manager updated = new Manager(old.userId, taskId, newPriority);
        pq.add(updated);
        record.put(taskId, updated);
    }

    public void rmv(int taskId) {
        record.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Manager top = pq.poll();
            Manager latest = record.get(top.taskId);

            if (latest == null) continue;               // removed
            if (latest.priority != top.priority) continue; // outdated priority

            // IMPORTANT: return userId from the latest record (not from the popped 'top'),
            // because userId may have changed for the same taskId.
            record.remove(top.taskId);
            return latest.userId;
        }
        return -1;
    }
}

// Small local test for the provided failing testcase
class Main {
    public static void main(String[] args) {
        List<List<Integer>> init = new ArrayList<>();
        init.add(Arrays.asList(1, 101, 8));
        init.add(Arrays.asList(2, 102, 20));
        init.add(Arrays.asList(3, 103, 5));

        TaskManager tm = new TaskManager(init);
        tm.add(4, 104, 5);
        tm.edit(102, 9);
        System.out.println(tm.execTop()); // expected 2
        tm.rmv(101);
        tm.add(50, 101, 8);
        System.out.println(tm.execTop()); // expected 50
    }
}
