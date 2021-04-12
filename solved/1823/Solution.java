import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (q.size() != 1) {
            dequeue(q, k);
        }
        return q.poll();
    }

    private void dequeue(Queue<Integer> q, int k) {
        for (int i = 0; i < k - 1; i++) {
            q.add(q.poll());
        }
        q.poll();
    }
}