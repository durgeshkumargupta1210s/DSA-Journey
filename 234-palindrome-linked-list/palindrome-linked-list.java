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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        // finding first middle element:-
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode new_head=Reverse(slow.next);
        ListNode first=head;
        ListNode second=new_head;

        while(second!=null){
            if(first.val!=second.val){
                // Reverse(new_head);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        // Reverse(new_head);
        return true;
    }
    public static ListNode Reverse(ListNode head){
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