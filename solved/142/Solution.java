import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Object> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head.next)) {
                return head.next;
            }
            map.put(head, new Object());
            head = head.next;
        }
        return null;
    }
}