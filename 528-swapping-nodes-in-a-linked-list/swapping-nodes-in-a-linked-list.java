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
    public ListNode swapNodes(ListNode head, int k) {
       ListNode temp1=head;
       ListNode temp2=head;
       ListNode temp=head;
       int count=0;

       while(temp!=null){
        count++;
        temp=temp.next;
       }

       for(int i=1; i<k; i++){
        temp1=temp1.next;
       } 

       for(int i=1; i<count-k+1; i++){
        temp2=temp2.next;
       } 

       int dummy=temp1.val;
       temp1.val=temp2.val;
       temp2.val=dummy;

       return head;
    }
}