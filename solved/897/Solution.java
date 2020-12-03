import java.util.ArrayList;
import java.util.List;

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
    private final List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;
        makeList(root);
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode tempNode = newRoot;
        for (int i=1; i<list.size(); i++) {
            tempNode = makeTree(tempNode, new TreeNode(list.get(i)));
        }
        return newRoot;
    }

    private void makeList(TreeNode node) {
        if (node == null) return;
        makeList(node.left);
        list.add(node.val);
        makeList(node.right);
    }

    private TreeNode makeTree(TreeNode node, TreeNode child) {
        return node.right = child;
    }
}