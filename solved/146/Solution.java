import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>() {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    };

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            put(key, cache.get(key));
        }
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */