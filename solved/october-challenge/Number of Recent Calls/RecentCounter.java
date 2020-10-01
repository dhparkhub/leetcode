import java.util.List;
import java.util.ArrayList;

class RecentCounter {
    private final List<Integer> requests = new ArrayList<>();
    private int firstValidIndex = 0;

    public RecentCounter() {
        // constructor
    }

    public int ping(int t) {
        requests.add(t);
        for (int i = firstValidIndex; i < requests.size(); i++) {
            if (requests.get(i) >= t - 3000) {
                firstValidIndex = i;
                break;
            }
        }
        return requests.size() - firstValidIndex;
    }
}