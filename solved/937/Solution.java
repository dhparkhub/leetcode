import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<String> letterLogs = new ArrayList<>();
    private final List<String> digitLogs = new ArrayList<>();

    public String[] reorderLogFiles(String[] logs) {
        for (String log : logs) {
            char temp = log.charAt(log.indexOf(' ') + 1);
            if (Character.isDigit(temp)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((log1, log2) -> {
            String temp1 = log1.substring(log1.indexOf(' ') + 1);
            String temp2 = log2.substring(log2.indexOf(' ') + 1);
            int comp = temp1.compareTo(temp2);
            return comp != 0 ? comp : log1.compareTo(log2);
        });

        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);
    }
}