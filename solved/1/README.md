# LeetCode 1. Two Sum (Java)

안녕하세요, 도해입니다. 오늘은 LeetCode [1. Two Sum](https://leetcode.com/problems/two-sum/) 문제를 한 번 풀어보겠습니다.

배열이 주어지고 배열에서 서로 다른 두 원소를 뽑아 그 합이 타겟(Target)이 되는 경우의 수를 찾아 두 원소의 인덱스를 반환하면 됩니다. 2중 반복문을 사용하여 문제를 해결할 수도 있지만 배열을 한 번만 탐색하여 문제를 해결해보도록 하겠습니다.

이 문제는 배열의 원소를 순차적으로 탐색하면서 해당 원소가 있었는지도 체크해야하지만, 그 원소의 인덱스 역시 저장을 해놔야 쉽게 답을 구할 수 있습니다. 그렇기 때문에 `Set`이 아니라 `Map`을 사용하여 (원소의 값, 원소의 인덱스)의 형태로 데이터를 저장하겠습니다.

이제 배열을 순차적으로 탐색합니다. 이미 탐색한 원소와 현재 원소의 합이 타겟이라면 두 원소의 인덱스를 바로 반환하면 됩니다. 만약 경우의 수를 찾지 못했다면 다음을 위해 원소의 값과 인덱스를 `Map`에 저장합니다. 문제에서 조건을 만족하는 경우의 수가 반드시 하나 존재한다고 언급했기 때문에 정답이 나오지 않는 경우는 고려하지 않았습니다.

```java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
```
