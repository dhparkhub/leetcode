import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) {
                list.add(temp);
                continue;
            }
            set.add(temp);
        }

        return list.stream().distinct().collect(Collectors.toList());
    }
}