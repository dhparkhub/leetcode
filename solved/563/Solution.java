import java.util.HashMap;
import java.util.Map;

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
    private final Map<TreeNode, Integer> cache = new HashMap<>();

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int l = findTilt(root.left);
        int r = findTilt(root.right);
        return treeTilt(root) + l + r;
    }

    private int treeSum(TreeNode root) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        int sum = root.val + leftSum + rightSum;
        cache.put(root, sum);
        return sum;
    }

    private int treeTilt(TreeNode root) {
        if (root == null) return 0;
        int l = treeSum(root.left);
        int r = treeSum(root.right);
        return Math.abs(l - r);
    }
}
