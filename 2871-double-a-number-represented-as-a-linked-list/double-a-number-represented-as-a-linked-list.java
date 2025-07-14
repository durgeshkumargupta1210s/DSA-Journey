class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        ListNode temp = head;
        int carry = 0;

        ListNode prev = null;
        while (temp != null) {
            int sum = temp.val * 2 + carry;
            temp.val = sum % 10;
            carry = sum / 10;

            prev = temp;
            temp = temp.next;
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return reverse(head);
    }
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
