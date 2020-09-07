public class ListNode {
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
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode headNode = null;
        ListNode tempNode = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;

            if (headNode == null) {
                headNode = tempNode = new ListNode(sum % 10);
            } else {
                tempNode.next = new ListNode(sum % 10);
                tempNode = tempNode.next;
            }

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if (carry == 1) {
            tempNode.next = new ListNode(1);
        }

        return headNode;
    }
}