# LeetCode 7. Reverse Integer | Java

- 주어진 정수의 역을 구해 반환해야 한다.

## Solution

- 정수의 역이란 가장 높은 자리수가 가장 낮은 자리수가 되고 가장 낮은 자리수가 가장 높은 자리수가 된다.
- 문제 해결 방법은 가장 낮은 자리수를 취한 다음 10을 곱하면서 자리수를 한 단계씩 올려주면 된다.
- 예를 들어 123 같은 경우, `((3 * 10) + 2) * 10 + 1` 같은 형태가 된다.
- 가장 높은 자리수가 아니라 가장 낮은 자리수로 하는 이유는 `%` 연산자를 통해 가장 낮은 자리수를 취하는게 더 쉽기 때문이다.

```java
int reversed = 0;
while (x != 0) {
  reversed = (reversed * 10) + (x % 10);
  x /= 10;
}
```

- 위 코드에서는 오버플로우라는 한 가지 더 해결해야할 문제가 남아있다.
- `1999999999`을 역으로 계산하면 `9999999991`가 되는데 이는 `int` 범위를 넘어버린다.
- 때문에 `reversed` 변수를 `long` 타입으로 변환해서 오버플로우를 탐색해야 한다.
- `reversed` 변수의 값과 `reversed` 변수에 `int` 형으로 타입 변환을 한 값이 다르면 오버플로우가 발생한 것을 알 수 있다.

```java
private boolean isOutOfRange(long num) {
  return num != (int) num;
}
```

- 완성된 코드는 아래와 같다.

```java
class Solution {
  public int reverse(int x) {
    long reversed = 0;
    while (x != 0) {
      reversed = (reversed * 10) + (x % 10);
      x /= 10;
    }//O(N)
    return isOutOfRange(reversed) ? 0 : (int) reversed;
  }//O(N)

  private boolean isOutOfRange(long num) {
    return num != (int) num;
  }//O(1)
}
```
