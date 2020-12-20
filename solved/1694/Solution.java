import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String reformatNumber(String number) {
        Queue<Character> q = new LinkedList<>();
        for (char ch : number.toCharArray()) {
            if (Character.isDigit(ch)) {
                q.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int qSize = q.size();
            if (qSize <= 3) {
                while (!q.isEmpty()) {
                    sb.append(q.poll());
                }
                break;
            }
            if (qSize == 4) {
                sb.append(q.poll()).append(q.poll()).append('-').append(q.poll()).append(q.poll());
                break;
            }
            sb.append(q.poll()).append(q.poll()).append(q.poll()).append('-');
        }

        return sb.toString();
    }
}