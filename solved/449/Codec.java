import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            sb.append(node.val).append(' ');
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] temp = data.split("\\s+");
        TreeNode root = null;
        for (String e : temp) {
            root = push(root, Integer.parseInt(e));// O(logN)
        }// O(NlogN)

        return root;
    }

    private TreeNode push(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.val) {
            node.left = push(node.left, data);
        } else {
            node.right = push(node.right, data);
        }

        return node;
    }// O(logN)
}
