import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0]) 
        );
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
            pq.offer(new double[]{gain, pass, total});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll(); 
            int pass = (int) top[1] + 1;
            int total = (int) top[2] + 1;
            double gain = ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
            pq.offer(new double[]{gain, pass, total});
        }
        double sum = 0.0;
        for (double[] c : pq) {
            sum += (double) c[1] / c[2];
        }

        return sum / classes.length;
    }
}
