class Solution {
    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos,
        int[][] friends,
        int id,
        int level
    ) {
        // BFS to find friends at exact 'level'
        boolean[] visited = new boolean[friends.length];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        visited[id] = true;
        
        // Traverse BFS exactly 'level' steps
        while (level-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int f : friends[curr]) {
                    if (!visited[f]) {
                        visited[f] = true;
                        queue.offer(f);
                    }
                }
            }
        }
        
        // Count frequencies of videos watched by friends at 'level'
        Map<String, Integer> freqMap = new HashMap<>();
        for (int person : queue) {
            for (String vid : watchedVideos.get(person)) {
                freqMap.merge(vid, 1, Integer::sum);
            }
        }
        
        // Sort videos by (frequency ascending, then lexicographically)
        List<String> result = new ArrayList<>(freqMap.keySet());
        result.sort((a, b) -> {
            int fa = freqMap.get(a);
            int fb = freqMap.get(b);
            if (fa == fb) {
                return a.compareTo(b);
            }
            return Integer.compare(fa, fb);
        });
        
        return result;
    }
}
