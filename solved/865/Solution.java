import java.util.*;

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        List<TreeNode> deepestNodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode tempNode = q.poll();
                tempList.add(tempNode);
                if (tempNode.left != null) {
                    parentsMap.put(tempNode.left, tempNode);
                    q.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    parentsMap.put(tempNode.right, tempNode);
                    q.add(tempNode.right);
                }
            }
            deepestNodes = tempList;
        }

        q = new LinkedList<>(deepestNodes);
        Set<TreeNode> nodeSet = new HashSet<>();
        while (q.size() > 1) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = parentsMap.get(q.poll());
                if (nodeSet.contains(node)) continue;
                nodeSet.add(node);
                q.add(node);
            }
        }

        return q.poll();
    }
}