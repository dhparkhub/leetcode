# LeetCode 2. Add Two Numbers (Java)

안녕하세요, 도해입니다. 오늘은 LeetCode [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) 문제를 한 번 풀어보겠습니다.

음이 아닌 두 정수가 연결 리스트로 주어질 때, 두 수의 합을 연결 리스트로 반환하면 됩니다. 주어진 두 노드는 각 수의 가장 낮은 자리수를 가리키고 있으므로 두 리스트를 순차적으로 탐색하면서 더해가면 됩니다.

첫 번째 주의할 점은 두 리스트의 길이가 다르다는 겁니다. 임의의 자리수에서 두 수를 덧셈할 때 한 리스트의 노드를 `NULL`을 가리킬 수 있으니 이 점을 유의해야 합니다.

두 번째 주의할 점은 각 자리수를 더하면서 생기는 올림값입니다. 올림값은 다음 자리수를 더할 때 함께 더해줘야 하며 가장 높은 자리수를 더할 때 올림값이 있다면 한 번 더 노드를 추가하는 작업을 해줘야 합니다.

2가지 사항에 유의하면서 두 리스트를 순차적으로 탐색하면서 자리수를 더해가면 됩니다. 원하는 리스트를 반환하기 위해 `head`를 선언하고 각 자리수를 더하면서 노드를 추가하기 위해 `tail`을 선언했습니다.

```java
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
```
