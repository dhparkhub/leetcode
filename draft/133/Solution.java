import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(1);

        boolean[] visited = new boolean[1001];
        Node[] nodes = new Node[1001];

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.val] = true;

        while (!q.isEmpty()) {
            Node tempNode = q.poll();
            Node copied = copyNode(nodes, tempNode);
            for (Node e : tempNode.neighbors) {
                if (!visited[e.val]) {
                    visited[e.val] = true;
                    q.add(e);
                }
                copied.neighbors.add(copyNode(nodes, e));
            }
        }

        return copyNode(nodes, node);
    }

    private Node copyNode(Node[] nodes, Node node) {
        if (nodes[node.val] == null) {
            return nodes[node.val] = new Node(node.val);
        }
        return nodes[node.val];
    }
}