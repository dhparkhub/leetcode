import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<String> letterLogs = new ArrayList<>();
    private final List<String> digitLogs = new ArrayList<>();

    public String[] reorderLogFiles(String[] logs) {
        for (String log : logs) {
            String temp = log.substring(log.indexOf(' ') + 1).replaceAll("\\s", "");
            if (temp.chars().allMatch(Character::isDigit)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((log1, log2) -> {
            String temp1 = log1.substring(log1.indexOf(' ') + 1);
            String temp2 = log2.substring(log2.indexOf(' ') + 1);
            int compare = temp1.compareTo(temp2);
            return compare == 0 ? log1.compareTo(log2) : compare;
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}