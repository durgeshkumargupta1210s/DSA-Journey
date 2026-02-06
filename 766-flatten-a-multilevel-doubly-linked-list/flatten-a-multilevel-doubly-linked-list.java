class Solution {

    /*
     * Function: flatten
     * -----------------
     * Flattens a multilevel doubly linked list into a single-level doubly linked list.
     *
     * Each node contains:
     * - next pointer
     * - prev pointer
     * - child pointer (which may point to another doubly linked list)
     *
     * Goal:
     * Convert the multilevel structure into a single-level doubly linked list
     * using depth-first traversal order.
     *
     * Approach: Iterative DFS using Stack
     *
     * Why Stack?
     * - When we encounter a child, we must process child first
     * - But we must not lose the original next node
     * - So we store next node in stack to reconnect later
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (worst case due to stack)
     */

    public Node flatten(Node head) {

        // Edge case: if list is empty
        if (head == null) return null;

        // temp pointer used for traversal
        Node temp = head;

        // Stack to store next nodes when child exists
        Stack<Node> st = new Stack<>();

        // Traverse entire list
        while (temp != null) {

            /*
             * Case 1: If current node has a child
             */
            if (temp.child != null) {

                /*
                 * If current node also has next node,
                 * push it into stack so we can reconnect later
                 */
                if (temp.next != null) {
                    st.push(temp.next);
                }

                /*
                 * Connect current node to child
                 */
                temp.next = temp.child;

                /*
                 * Set child's prev pointer to current node
                 */
                temp.child.prev = temp;

                /*
                 * Remove child pointer since it's now flattened
                 */
                temp.child = null;
            }

            /*
             * Case 2: If we reached end of current level
             * and stack is not empty, reconnect previous next node
             */
            if (temp.next == null && !st.isEmpty()) {

                // Get last stored next node
                Node n = st.pop();

                // Connect it
                temp.next = n;
                n.prev = temp;
            }

            /*
             * Move to next node
             */
            temp = temp.next;
        }

        /*
         * Return flattened list head
         */
        return head;
    }
}
