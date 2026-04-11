class Solution {
    public int scheduleCourse(int[][] courses) {

        // Step 1: Sort courses by their deadline (lastDay)
        // Greedy idea: try to finish courses with earlier deadlines first
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Max Heap to store durations of selected courses
        // Why max heap? → so we can remove the longest course when needed
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Total time spent so far
        int time = 0;

        // Step 2: Iterate through sorted courses
        for(int[] c : courses){
            int duration = c[0];
            int lastDay = c[1];

            // Take the current course
            time += duration;
            maxHeap.add(duration);

            // If total time exceeds deadline → we must fix it
            if(time > lastDay){

                // Remove the longest duration course taken so far
                // This is optimal because it frees maximum time
                time -= maxHeap.poll();
            }
        }

        // Remaining courses in heap = maximum number of courses we can take
        return maxHeap.size();
    }
}