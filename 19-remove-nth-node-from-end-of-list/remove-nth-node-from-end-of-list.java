class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;

        // Count total number of nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If we are to remove the head
        if (n == count) {
            return head.next;
        }

        // Find (count - n - 1)th node (previous node of the one to delete)
        int k = count - n - 1;
        temp = head;
        while (k-- > 0) {
            temp = temp.next;
        }

        // Remove the nth node from end
        temp.next = temp.next.next;

        return head;
    }
}
