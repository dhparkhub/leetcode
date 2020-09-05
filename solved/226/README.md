# [Leetcode] 226. Invert Binary Tree

주어진 이진 트리의 좌우를 반전시키는 문제다. 임의의 노드에 대해 왼쪽 자식과 오른쪽 자식을 바꿔주면 된다고 생각했고, 모든 노드에 대해 좌우 반전을 수행할 수 있도록 재귀를 사용했다. 모든 노드에 대해 좌우 반전을 수행하므로 시간 복잡도는 `O(N)`이다.

```java
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
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }// O(N)
}
```
