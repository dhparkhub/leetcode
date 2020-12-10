import java.util.Stack;

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
    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        push(stack, root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        push(stack, temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void push(Stack<TreeNode> stack, TreeNode root) {
        if (root == null) return;
        stack.push(root);
        push(stack, root.left);
    }
}