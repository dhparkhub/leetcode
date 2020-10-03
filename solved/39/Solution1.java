import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private final List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new LinkedList<>());
        return answer;
    }

    private void backtrack(int[] candidates, int target, int index, LinkedList<Integer> combination) {
        if (target == 0) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, combination);
            combination.removeLast();
        }
    }
}