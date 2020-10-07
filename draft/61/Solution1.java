import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, ListNode> nodeMap = new HashMap<>();
        ListNode tempNode = head;
        for (int i = 0; ; i++, tempNode = tempNode.next) {
            nodeMap.put(i, tempNode);
            if (tempNode.next == null) {
                tempNode.next = head;
                break;
            }
        }

        k %= nodeMap.size();
        int headIndex = (nodeMap.size() - k) % nodeMap.size();
        int tailIndex = headIndex != 0 ? headIndex - 1 : nodeMap.size() - 1;
        nodeMap.get(tailIndex).next = null;
        return nodeMap.get(headIndex);
    }
}