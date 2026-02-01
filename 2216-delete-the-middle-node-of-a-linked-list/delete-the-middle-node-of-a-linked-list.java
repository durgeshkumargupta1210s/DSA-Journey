/**
 * Definition for singly-linked list.
 * Each node contains an integer value and a reference to the next node.
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */

class Solution {

    /**
     * This function deletes the middle node of a singly linked list.
     *
     * Approach:
     * - Use two pointers: slow and fast.
     * - Fast pointer moves 2 steps, slow pointer moves 1 step.
     * - When fast reaches the end, slow will be at the middle node.
     * - Use a prev pointer to track the node before slow.
     */
    public ListNode deleteMiddle(ListNode head) {

        // Edge case: If list has only one node, deleting middle means return null
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers at the head
        ListNode fast = head;
        ListNode slow = head;

        // prev will store the node just before the slow pointer
        ListNode prev = null;

        // Traverse the list until fast reaches the end
        while (fast != null && fast.next != null) {

            // Update prev before moving slow
            prev = slow;

            // Move slow pointer by one step
            slow = slow.next;

            // Move fast pointer by two steps
            fast = fast.next.next;
        }

        // Now slow is pointing to the middle node
        // Delete the middle node by skipping it
        prev.next = slow.next;

        // Return the modified linked list head
        return head;
    }
}
