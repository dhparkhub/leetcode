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
    private TreeNode root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

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
        if (data == null) {
            return null;
        }

        String[] temp = data.split("\\s+");
        for (String e : temp) {
            push(root, Integer.parseInt(e));
        }

        return root;
    }

    private void push(TreeNode node, int data) {
        if (node == null) {
            root = new TreeNode(data);
            return;
        }

        if (data < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                push(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(data);
            } else {
                push(node.right, data);
            }
        }
    }
}