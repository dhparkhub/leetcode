import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }
        s = sb.toString();

        Deque<Integer> numbers = new LinkedList<>();
        Deque<Character> operators = new LinkedList<>();

        char[] chArr = s.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];

            if (ch == '+' || ch == '-') {
                operators.addLast(ch);
                continue;
            }

            if (Character.isDigit(ch)) {
                int temp = 0;
                int j = i;
                while (j < chArr.length && Character.isDigit(chArr[j])) {
                    temp = temp * 10 + (chArr[j] - '0');
                    i = j++;
                }
                numbers.addLast(temp);
                continue;
            }

            int temp = 0;
            int j = i + 1;
            while (j < chArr.length && Character.isDigit(chArr[j])) {
                temp = temp * 10 + (chArr[j] - '0');
                i = j++;
            }
            int temp2 = numbers.removeLast();
            numbers.addLast(ch == '*' ? temp2 * temp : temp2 / temp);
        }

        int answer = numbers.removeFirst();
        while (!operators.isEmpty()) {
            int temp = numbers.removeFirst();
            char operator = operators.removeFirst();
            if (operator == '+') {
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }

        return answer;
    }
}