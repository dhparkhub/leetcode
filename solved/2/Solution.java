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
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            int val = sum % 10;
            carry = sum / 10;

            if (head == null) {
                head = tail = new ListNode(val, null);
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        if (carry == 1) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}