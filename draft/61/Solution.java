import java.util.ArrayList;
import java.util.List;

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
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int temp = k % list.size();

        ListNode headNode = null;
        ListNode tempNode = null;
        for (int i = 0; i < list.size(); i++) {
            int index = (list.size() - temp + i) % list.size();
            if (headNode == null) {
                headNode = tempNode = new ListNode(list.get(index));
                continue;
            }
            tempNode.next = new ListNode(list.get(index));
            tempNode = tempNode.next;
        }

        return headNode;
    }
}