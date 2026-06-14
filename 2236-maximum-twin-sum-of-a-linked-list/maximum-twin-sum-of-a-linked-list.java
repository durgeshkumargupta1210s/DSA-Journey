class Solution {
    public int pairSum(ListNode head) {
        List<Integer> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        int ans = 0;

        for (int i = 0; i < nodes.size() / 2; i++) {
            int sum = nodes.get(i) + nodes.get(nodes.size() - 1 - i);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}