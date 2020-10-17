import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix.length == 1) return Arrays.binarySearch(matrix[0], target) >= 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = getValue(matrix, mid, n);
            if (target == midVal) return true;
            if (target < midVal) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    private int getValue(int[][] matrix, int index, int n) {
        return matrix[index / n][index % n];
    }
}