/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1new =reverse(l1);
        ListNode l2new = reverse(l2);
        ListNode t1 = l1new;
        ListNode t2 = l2new;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;

        while (t1 != null || t2 != null) {
            int sum = carry;

            if (t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            }

            if (t2 != null) {
                sum += t2.val;
                t2 = t2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        // return dummy.next;
        ListNode ans=reverse(dummy.next);
        return ans;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}
