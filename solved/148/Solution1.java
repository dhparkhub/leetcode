import java.util.*;

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }// O(N)

        list.sort(Comparator.comparingInt(o -> o.val));// O(NlogN)

        ListNode headNode = list.get(0);
        ListNode tempNode = headNode;
        for (int i = 1; i < list.size(); i++) {
            tempNode.next = list.get(i);
            tempNode = tempNode.next;
        }// O(N)
        tempNode.next = null;

        return headNode;
    }
}