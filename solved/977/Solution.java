import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(i -> i * i).sorted().toArray();
    }
}