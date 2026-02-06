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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        while(head!=null){
           list.add(head.val);
           head=head.next;
        }
        int [] ans=new int[list.size()];

        Stack<Integer> st=new Stack<>();

        for(int i=0; i<list.size(); i++){
            while(!st.isEmpty() && list.get(i)>list.get(st.peek())){
                ans[st.pop()]=list.get(i);
            }
            st.push(i);
        }
        return ans;
        
    }
}