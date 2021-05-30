# [Java] LeetCode 454. 4Sum II

안녕하세요, 도해입니다. 오늘은 LeetCode [454. 4Sum II](https://leetcode.com/problems/4sum-ii/) 문제를 한 번 풀어보겠습니다.

길이가 같은 4개의 배열이 주어지고, 4개의 배열에서 각 원소를 하나씩 골라 합한 값이 0이 되는 경우의 수를 모두 찾아야 하는 문제입니다. 막연하게 4중으로 반복문을 돌면서 문제를 해결할 수도 있지만 저는 문제를 분할해서 해결하기로 했습니다.

배열을 임의의 두 그룹으로 나눕니다. 1번 그룹에 2개의 배열이 있고 2번 그룹에는 나머지 2개의 배열이 있습니다. 이제 1번 그룹에 있는 두 배열의 원소를 하나씩 선택하여 더했을 때 나올 수 있는 모든 값과 값이 나온 횟수를 `Map`에 저장합니다.

```java
Map<Integer, Integer> map = new HashMap<>();
for (int i : nums1) {
  for (int j : nums2) {
    map.put(i + j, map.getOrDefault(i + j, 0) + 1);
  }
}// O(N^2)
```

2번 그룹도 마찬가지로 두 배열의 원소를 하나씩 선택하여 더해가면서 문제를 해결합니다. 두 원소의 합이 `a`라면 1번 그룹에서 정제한 `Map`에 `-a`가 있으면 됩니다. 주의할 점은 `-a`가 나온 모든 경우의 수를 더해줘야 한다는 겁니다.

```java
int answer = 0;
for (int i : nums3) {
  for (int j : nums4) {
    answer += map.getOrDefault(-(i + j), 0);
  }
}// O(N^2)
```

## Solution

```java
class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums1) {
      for (int j : nums2) {
        map.put(i + j, map.getOrDefault(i + j, 0) + 1);
      }
    }// O(N^2)
    int answer = 0;
    for (int i : nums3) {
      for (int j : nums4) {
        answer += map.getOrDefault(-(i + j), 0);
      }
    }// O(N^2)
    return answer;
  }// O(N^2)
}
```
