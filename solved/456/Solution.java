import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        List<List<Integer>> list = new ArrayList<>();
        int minNum = Integer.MIN_VALUE;
        int maxNum = Integer.MAX_VALUE;
        for (int num : nums) {
            for (List<Integer> e : list) {
                if (num > e.get(0) && num < e.get(1)) {
                    return true;
                }
            }
            if (minNum == Integer.MIN_VALUE) {
                minNum = num;
                continue;
            }
            if (num < minNum) {
                if (maxNum != Integer.MAX_VALUE) {
                    list.add(Arrays.asList(minNum, maxNum));
                }
                minNum = num;
                maxNum = Integer.MAX_VALUE;
                continue;
            }
            if (maxNum == Integer.MAX_VALUE) {
                maxNum = num;
                continue;
            }
            if (num > maxNum) {
                maxNum = num;
                continue;
            }
            if (num > minNum && num < maxNum) {
                return true;
            }
        }

        return false;
    }
}