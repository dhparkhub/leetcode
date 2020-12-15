import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        bruteforce(s, 0, new ArrayList<>());
        return answer;
    }

    private void bruteforce(String s, int idx, List<String> list) {
        if (idx == s.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (!isPalindrome(s, idx, i)) continue;
            list.add(s.substring(idx, i + 1));
            bruteforce(s, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}