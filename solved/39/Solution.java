import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private final List<List<Integer>> answer = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        combinationSum(0, target, new ArrayList<>());
        return answer.stream().distinct().collect(Collectors.toList());
    }

    private void combinationSum(int index, int target, List<Integer> list) {
        if (target == 0) {
            answer.add(list);
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        combinationSum(index + 1, target, list);

        for (int i = 1; target >= 0; i++) {
            target -= candidates[index];
            List<Integer> tempList = new ArrayList<>(list);
            for (int j = 0; j < i; j++) {
                tempList.add(candidates[index]);
            }
            combinationSum(index, target, tempList);
        }
    }
}