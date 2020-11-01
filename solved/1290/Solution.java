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
    public int getDecimalValue(ListNode head) {
        int answer = 0;
        while (head != null) {
            answer = answer << 1;
            answer |= head.val;
            head = head.next;
        }
        return answer;
    }
}