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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode headNode = null;
        ListNode tempNode = null;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (headNode == null) {
                    headNode = tempNode = l1;
                } else {
                    tempNode.next = l1;
                    tempNode = tempNode.next;
                }
                l1 = l1.next;
            } else {
                if (headNode == null) {
                    headNode = tempNode = l2;
                } else {
                    tempNode.next = l2;
                    tempNode = tempNode.next;
                }
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            tempNode.next = l1;
            tempNode = tempNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            tempNode.next = l2;
            tempNode = tempNode.next;
            l2 = l2.next;
        }

        return headNode;
    }
}