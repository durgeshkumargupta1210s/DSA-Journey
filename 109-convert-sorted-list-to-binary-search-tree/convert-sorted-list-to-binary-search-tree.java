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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /**
     * Converts a sorted linked list into a height-balanced BST.
     *
     * Approach:
     * Step 1: Convert Linked List → Array (random access needed)
     * Step 2: Build BST using middle element (same as sortedArrayToBST)
     */
    public TreeNode sortedListToBST(ListNode head) {

        // Convert Linked List to ArrayList
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // Build BST from sorted array/list
        return createTree(list, 0, list.size() - 1);
    }

    /**
     * Recursive function to construct balanced BST
     */
    public TreeNode createTree(List<Integer> list, int start, int end) {

        /**
         * Base Case:
         * If indices cross → no node
         */
        if (start > end) {
            return null;
        }

        /**
         * Pick middle element → ensures balance
         */
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        /**
         * Recursively build left subtree
         */
        root.left = createTree(list, start, mid - 1);

        /**
         * Recursively build right subtree
         */
        root.right = createTree(list, mid + 1, end);

        return root;
    }
}