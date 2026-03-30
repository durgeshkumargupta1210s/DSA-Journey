/*
 // Definition for a Node.
 class Node {
     public int val;
     public List<Node> neighbors;

     public Node() {
         val = 0;
         neighbors = new ArrayList<Node>();
     }

     public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<Node>();
     }

     public Node(int _val, ArrayList<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
     }
 }
*/

class Solution {
    public Node cloneGraph(Node node) {

        // 🔹 Edge case
        if (node == null) return null;

        // 🔹 Map: original node → cloned node
        Map<Node, Node> map = new HashMap<>();

        // 🔹 Queue for BFS
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        // 🔹 Create clone of starting node
        map.put(node, new Node(node.val));

        // 🔹 BFS traversal
        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node neighbor : curr.neighbors) {

                // If neighbor not cloned yet
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }

                // Connect cloned nodes
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        // 🔹 Return cloned graph starting node
        return map.get(node);
    }
}