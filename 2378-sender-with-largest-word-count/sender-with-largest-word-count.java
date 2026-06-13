class Solution {
    public String largestWordCount(String[] messages, String[] senders) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < senders.length; i++) {
            String[] arr = messages[i].split(" ");
            map.put(senders[i],
                    map.getOrDefault(senders[i], 0) + arr.length);
        }

        int max = 0;
        List<String> ans = new ArrayList<>();

        for (String key : map.keySet()) {

            if (map.get(key) > max) {
                max = map.get(key);
                ans.clear();
                ans.add(key);
            } 
            else if (map.get(key) == max) {
                ans.add(key);
            }
        }

        Collections.sort(ans);

        return ans.get(ans.size() - 1);
    }
}