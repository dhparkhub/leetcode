import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private final List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0, new ArrayList<>());
        return answer;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> combination) {
        if (target == 0) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        combinationSum(candidates, target, index + 1, new ArrayList<>(combination));

        while (target > 0) {
            target -= candidates[index];
            combination.add(candidates[index]);
            combinationSum(candidates, target, index + 1, new ArrayList<>(combination));
        }
    }
}