import java.util.*;

class Solution {

    static final int MAX = 10000;

    public int minOperations(int n, int m) {
        // If start or end is prime → impossible
        boolean[] isPrime = sieve();
        if (isPrime[n] || isPrime[m]) return -1;

        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        dist[n] = n;
        pq.offer(new int[]{n, n}); 

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int num = cur[1];

            if (num == m) return cost;
            if (cost > dist[num]) continue;

            char[] digits = String.valueOf(num).toCharArray();

            for (int i = 0; i < digits.length; i++) {
                char original = digits[i];

                // Increase digit
                if (digits[i] < '9') {
                    digits[i]++;
                    relax(num, digits, cost, dist, pq, isPrime);
                }

                // Decrease digit
                digits[i] = original;
                if (digits[i] > '0') {
                    digits[i]--;
                    relax(num, digits, cost, dist, pq, isPrime);
                }

                digits[i] = original;
            }
        }

        return -1;
    }

    private void relax(int num, char[] digits, int cost,
                       int[] dist, PriorityQueue<int[]> pq, boolean[] isPrime) {

        int next = Integer.parseInt(new String(digits));
        if (isPrime[next]) return;

        int newCost = cost + next;
        if (newCost < dist[next]) {
            dist[next] = newCost;
            pq.offer(new int[]{newCost, next});
        }
    }

    // Sieve of Eratosthenes
    private boolean[] sieve() {
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
