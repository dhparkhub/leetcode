# LeetCode 1. Two Sum | Java

- 배열의 원소들 중 두 원소의 합이 `target`이 되는 경우를 찾아 두 원소의 인덱스를 반환해야 한다.

## Solution 1

- 가장 무난하고 러프하게 풀 수 있는 방법은 2중 반복문을 도는 것이다.
- 모든 케이스를 다 조사하는 것이기 때문에 `brute-force` 알고리즘이라고 할 수 있다.
- 두 수의 합이 `target`이 되는 경우가 있다면 두 수의 인덱스를 반환한다.

```java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }//O(N^2)
    return null;
  }//O(N^2)
}
```

- 2중 반복문이 사용되었기 때문에 최악의 경우 `O(N^2)`의 시간 복잡도를 가진다.
- 별도의 공간을 사용하지 않았기 때문에 공간 복잡도는 `O(1)`이 된다.

## Solution 2

- 배열을 순차적으로 탐색하면서 배열의 값과 인덱스를 저장한다.
- 이때, `HashMap`을 사용하는데 배열의 임의의 원소에 대해 값과 인덱스 쌍을 저장한다.
- 한 번 저장한 값은 `HashMap`의 키를 통해 `O(1)` 시간에 찾을 수 있다.
- 임의의 원소를 탐색할 때 `HashMap`에서 두 수의 합이 `target`이 되는 수가 있는지 탐색한다.
- 있다면 두 수의 인덱스를 반환하면 된다.

```java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }//O(N)
    return null;
  }//O(N)
}
```

- 배열을 선형 탐색하고 있으며 `HashMap`의 연산이 `O(1)`이기 때문에 전체 시간 복잡도는 `O(N)`이 된다.
- 공간 복잡도는 `HashMap`을 사용했기 때문에 `O(N)`이 된다.
