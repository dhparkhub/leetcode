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
    private final Map<TreeNode, Integer> minMap = new HashMap<>();
    private final Map<TreeNode, Integer> maxMap = new HashMap<>();

    public int maxAncestorDiff(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int ret = 0;
        if (root.left != null) {
            int lMin = findMinVal(root.left);
            int lMax = findMaxVal(root.left);
            ret = Math.max(ret, Math.abs(root.val - lMin));
            ret = Math.max(ret, Math.abs(root.val - lMax));
            ret = Math.max(ret, maxAncestorDiff(root.left));
        }
        if (root.right != null) {
            int rMin = findMinVal(root.right);
            int rMax = findMaxVal(root.right);
            ret = Math.max(ret, Math.abs(root.val - rMin));
            ret = Math.max(ret, Math.abs(root.val - rMax));
            ret = Math.max(ret, maxAncestorDiff(root.right));
        }
        return ret;
    }

    private int findMinVal(TreeNode root) {
        if (minMap.containsKey(root)) return minMap.get(root);
        int minVal = root.val;
        if (root.left != null) {
            minVal = Math.min(minVal, findMinVal(root.left));
        }
        if (root.right != null) {
            minVal = Math.min(minVal, findMinVal(root.right));
        }
        minMap.put(root, minVal);
        return minVal;
    }

    private int findMaxVal(TreeNode root) {
        if (maxMap.containsKey(root)) return maxMap.get(root);
        int maxVal = root.val;
        if (root.left != null) {
            maxVal = Math.max(maxVal, findMaxVal(root.left));
        }
        if (root.right != null) {
            maxVal = Math.max(maxVal, findMaxVal(root.right));
        }
        maxMap.put(root, maxVal);
        return maxVal;
    }
}