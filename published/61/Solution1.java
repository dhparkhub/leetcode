import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        List<ListNode> list = new ArrayList<>();
        while (true) {
            list.add(head);
            if (head.next == null) {
                head.next = list.get(0);
                break;
            }
            head = head.next;
        }

        k %= list.size();
        int headIndex = (list.size() - k) % list.size();
        int tailIndex = headIndex != 0 ? headIndex - 1 : list.size() - 1;
        list.get(tailIndex).next = null;
        return list.get(headIndex);
    }
}