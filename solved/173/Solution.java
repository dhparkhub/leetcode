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

class BSTIterator {
    private final List<TreeNode> list = new ArrayList<>();
    private int index = -1;

    public BSTIterator(TreeNode root) {
        makeNodeSet(root);
    }

    private void makeNodeSet(TreeNode root) {
        if (root == null) return;
        makeNodeSet(root.left);
        list.add(root);
        makeNodeSet(root.right);
    }

    public int next() {
        return list.get(++index).val;
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }
}