import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            int asteroid = list.get(i);
            if (crushed(list, i)) {
                i = asteroid > 0 ? i - 1 : i - 2;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private boolean crushed(List<Integer> list, int index) {
        if (!valid(list, index)) return false;

        int asteroid = list.get(index);
        if (asteroid > 0) {
            if (!valid(list, index + 1)) return false;
            if (list.get(index + 1) > 0) return false;
            int temp = list.get(index + 1);
            list.remove(index + 1);
            if (asteroid + temp == 0) {
                list.remove(index);
            } else {
                list.set(index, asteroid > -temp ? asteroid : temp);
            }
        } else {
            if (!valid(list, index - 1)) return false;
            if (list.get(index - 1) < 0) return false;
            int temp = list.get(index - 1);
            list.remove(index);
            if (asteroid + temp == 0) {
                list.remove(index - 1);
            } else {
                list.set(index - 1, asteroid < -temp ? asteroid : temp);
            }
        }
        return true;
    }

    private boolean valid(List<Integer> list, int index) {
        return index >= 0 && index < list.size();
    }
}