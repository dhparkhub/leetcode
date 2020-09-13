import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        return getNumDecodings(s.toCharArray(), 0);
    }

    private int getNumDecodings(char[] chArr, int index) {
        if (index == chArr.length) {
            return 1;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int tempNum1 = Character.getNumericValue(chArr[index]);
        if (tempNum1 == 0) {
            cache.put(index, 0);
            return 0;
        }

        int case1 = getNumDecodings(chArr, index + 1);
        if (index == chArr.length - 1) {
            cache.put(index, case1);
            return case1;
        }

        int tempNum2 = tempNum1 * 10 + Character.getNumericValue(chArr[index + 1]);
        if (tempNum2 == 0 || tempNum2 > 26) {
            cache.put(index, case1);
            return case1;
        }

        int case2 = getNumDecodings(chArr, index + 2);
        cache.put(index, case1 + case2);
        return case1 + case2;
    }
}