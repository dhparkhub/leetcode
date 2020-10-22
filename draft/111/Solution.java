import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static class TreeNodeWithDepth {
        TreeNode treeNode;
        int depth;

        TreeNodeWithDepth(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNodeWithDepth> q = new LinkedList<>();
        q.add(new TreeNodeWithDepth(root, 1));

        while (!q.isEmpty()) {
            TreeNodeWithDepth treeNodeWithDepth = q.poll();
            TreeNode treeNode = treeNodeWithDepth.treeNode;
            if (treeNode.left == null && treeNode.right == null) {
                return treeNodeWithDepth.depth;
            }
            if (treeNode.left != null) {
                q.add(new TreeNodeWithDepth(treeNode.left, treeNodeWithDepth.depth + 1));
            }
            if (treeNode.right != null) {
                q.add(new TreeNodeWithDepth(treeNode.right, treeNodeWithDepth.depth + 1));
            }
        }

        return -1;
    }
}