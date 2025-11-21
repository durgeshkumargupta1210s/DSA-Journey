class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node temp = head;
        Stack<Node> st = new Stack<>();

        while (temp != null) {

            if (temp.child != null) {

                if (temp.next != null) {
                    st.push(temp.next);
                }

                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
            
            if (temp.next == null && !st.isEmpty()) {
                Node n = st.pop();
                temp.next = n;
                n.prev = temp;
            }

            temp = temp.next;
        }

        return head;
    }
}
