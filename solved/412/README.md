# LeetCode 412. Fizz Buzz (Java)

안녕하세요, 도해입니다. 오늘은 LeetCode [412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz/) 문제를 한 번 풀어보겠습니다.

`N`이하 자연수에 대해 각 자연수에 대응하는 문자열을 출력하면 됩니다. 임의의 자연수가 3으로 나누어지면 `Fizz`를 5로 나누어지면 `Buzz`를 3과 5로 모두 나누어지면 `FizzBuzz`를 출력하면 됩니다. 나머지 경우 해당 자연수를 그대로 출력하면 됩니다.

저는 `StringBuilder`를 사용하여 3으로 나누어질 때 `Fizz` 문자열을 추가하고, 5로 나누어질 때 `Buzz` 문자열을 추가했습니다. 그러면 자연적으로 3과 5로 나누어질 때 `FizzBuzz` 문자열이 되기 때문입니다. 만약 `StringBuilder`가 비어있다면 자연수를 그대로 출력합니다.

```java
class Solution {
  public List<String> fizzBuzz(int n) {
    List<String> answer = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      if (i % 3 == 0) sb.append("Fizz");
      if (i % 5 == 0) sb.append("Buzz");
      answer.add(sb.length() == 0 ? String.valueOf(i) : sb.toString());
    }
    return answer;
  }
}
```
