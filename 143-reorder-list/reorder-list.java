class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Finding middle element
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Splitting the list from the middle
        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;

        // Reversing the second half of the linked list
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Merging two halves
        ListNode t1 = head, t2 = prev;
        while (t2 != null) {
            ListNode m1 = t1.next;
            ListNode m2 = t2.next;
            t1.next = t2;
            t2.next = m1;
            t1 = m1;
            t2 = m2;
        }
    }
}