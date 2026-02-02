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

    // Main function to double the number represented by the linked list
    public ListNode doubleIt(ListNode head) {

        // Step 1: Reverse the linked list
        // Why? Because doubling is easier from the last digit (like normal multiplication)
        head = reverse(head);

        // Variable to store carry during multiplication
        int carry = 0;

        // Pointer to traverse the reversed list
        ListNode temp = head;

        // Pointer to keep track of the last processed node
        ListNode prev = null;

        // Step 2: Traverse the linked list and double each digit
        while (temp != null) {

            // Multiply current digit by 2 and add carry from previous digit
            int sum = temp.val * 2 + carry;

            // Update the current node value with the last digit of sum
            temp.val = sum % 10;

            // Update carry (first digit of sum)
            carry = sum / 10;

            // Move prev pointer forward
            prev = temp;

            // Move to next node
            temp = temp.next;
        }

        // Step 3: If carry is still left, add a new node at the end
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        // Step 4: Reverse the list again to restore original order
        head = reverse(head);

        // Return the final updated linked list
        return head;
    }

    // Helper function to reverse a linked list using recursion
    public ListNode reverse(ListNode head) {

        // Base Case:
        // If list is empty or has only one node, it is already reversed
        if (head == null || head.next == null)
            return head;

        // Step 1: Reverse the remaining part of the list
        ListNode newHead = reverse(head.next);

        // Step 2: Make the next node point back to current node
        head.next.next = head;

        // Step 3: Break the original forward link
        head.next = null;

        // Step 4: Return new head of reversed list
        return newHead;
    }
}
