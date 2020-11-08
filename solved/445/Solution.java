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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        return addTwoListNode(l1, l2);
    }

    private ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) return listNode;
        ListNode head = null;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    private ListNode addTwoListNode(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            head = new ListNode(sum % 10, head);
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return carry == 1 ? new ListNode(carry, head) : head;
    }
}