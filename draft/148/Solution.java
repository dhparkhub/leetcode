import java.util.Comparator;
import java.util.PriorityQueue;

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

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null) {
            pq.add(head);
            head = head.next;
        }// O(NlogN)

        ListNode headNode = pq.poll();
        ListNode tempNode = headNode;
        while (!pq.isEmpty()) {
            tempNode.next = pq.poll();
            tempNode = tempNode.next;
        }// O(NlogN)

        tempNode.next = null;// prevent cycle

        return headNode;
    }
}