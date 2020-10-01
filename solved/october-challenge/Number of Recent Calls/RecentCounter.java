import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private final Queue<Integer> requests = new LinkedList<>();

    public RecentCounter() {
        // constructor
    }

    public int ping(int t) {
        requests.add(t);
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        return requests.size();
    }
}