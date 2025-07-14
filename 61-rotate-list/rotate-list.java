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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail=head;
       int len=1;
       if(head==null || k==0) return head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        ListNode prevNode=getnthNode(head,len-k);
        head=prevNode.next;
        prevNode.next=null;
        return head;

    }

    public static ListNode getnthNode(ListNode head, int k){
        int cnt=1;
        while(head!=null){
            if(cnt==k)return head;
            cnt++;
            head=head.next;
        }
        return head;
    }
}