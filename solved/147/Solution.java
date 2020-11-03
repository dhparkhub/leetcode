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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while (curNode != null) {
            curNode.next = null;// prevent cycle
            newHead = insertNode(newHead, curNode);
            curNode = nextNode;
            nextNode = curNode == null ? null : curNode.next;
        }

        return newHead;
    }

    private ListNode insertNode(ListNode head, ListNode node) {
        // list is empty
        if (head == null) return node;

        // node is less or equal than head
        if (node.val <= head.val) {
            node.next = head;
            return node;
        }

        // find appropriate place to insert node
        ListNode temp = head;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            if (node.val > temp.val && node.val <= temp.next.val) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }

        return head;
    }
}