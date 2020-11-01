import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length || nums[i + 1] != nums[i] + 1) {
                list.add(String.valueOf(nums[i]));
                continue;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            list.add(sb.append("->").append(nums[i]).toString());
        }
        return list;
    }
}