/**
 * Definition for singly-linked list.
 * Each node contains a binary digit (0 or 1).
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
     * This function converts a binary number stored in a linked list
     * into its decimal (integer) equivalent.
     *
     * Example:
     * Linked List: 1 -> 0 -> 1
     * Binary String: "101"
     * Decimal Value: 5
     */
    public int getDecimalValue(ListNode head) {
        
        // Step 1: Create an empty string to store binary digits
        String str = "";

        // Step 2: Traverse the linked list
        while (head != null) {
            
            // Append current node value (0 or 1) to the string
            str += head.val;

            // Move to the next node
            head = head.next;
        }

        // Step 3: Convert the binary string into decimal integer
        // Integer.parseInt(str, 2) converts base-2 string to base-10 number
        return Integer.parseInt(str, 2);
    }
}
