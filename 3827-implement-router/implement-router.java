import java.util.*;

public class Router {
    private final int memoryLimit;
    private final Deque<Packet> queue;
    private final Set<Packet> uniquePackets;
    // Map from destination -> list of timestamps (in increasing order because timestamps in addPacket are non-decreasing)
    private final Map<Integer, List<Integer>> destTimestamps;
    // For each destination, how many packets have been forwarded (so we don't count those timestamps)
    private final Map<Integer, Integer> processedCount;

    // Packet class
    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            this.source = s;
            this.destination = d;
            this.timestamp = t;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet p = (Packet) o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }
        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    // Constructor that LeetCode expects
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.uniquePackets = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.processedCount = new HashMap<>();
    }

    // LeetCode expects: boolean addPacket(int source, int destination, int timestamp)
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(p)) {
            return false;
        }
        // If memory full, remove the oldest
        if (queue.size() == memoryLimit) {
            forwardPacket();  // this will also manage removing from other structures
        }
        // Add new packet
        queue.offer(p);
        uniquePackets.add(p);
        destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    // LeetCode expects: List<Integer> forwardPacket()
    public List<Integer> forwardPacket() {
        if (queue.isEmpty()) {
            return Collections.emptyList();
        }
        Packet p = queue.poll();
        uniquePackets.remove(p);
        // Mark that one packet for this destination has been forwarded
        processedCount.merge(p.destination, 1, Integer::sum);
        return Arrays.asList(p.source, p.destination, p.timestamp);
    }

    // LeetCode expects: int getCount(int destination, int startTime, int endTime)
    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) {
            return 0;
        }
        List<Integer> timestamps = destTimestamps.get(destination);
        int forwarded = processedCount.getOrDefault(destination, 0);
        // We should only consider timestamps from index = forwarded to end

        // Use binary search on timestamps list
        int left = firstGreaterEqual(timestamps, forwarded, startTime);
        int right = firstGreater(timestamps, forwarded, endTime);
        return right - left;
    }

    // helper: first index >= target, starting from 'l'
    private int firstGreaterEqual(List<Integer> arr, int l, int target) {
        int lo = l, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // helper: first index > target, starting from 'l'
    private int firstGreater(List<Integer> arr, int l, int target) {
        int lo = l, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
