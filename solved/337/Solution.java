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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int l = 0;
        if (root.left != null) {
            l = rob(root.left.left) + rob(root.left.right);
        }

        int r = 0;
        if (root.right != null) {
            r = rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.val + l + r, rob(root.left) + rob(root.right));
    }
}