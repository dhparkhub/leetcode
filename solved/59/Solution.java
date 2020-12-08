class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        generateMatrix(arr, 0, 0, n, 1);
        return arr;
    }

    private void generateMatrix(int[][] arr, int r, int c, int n, int k) {
        if (n <= 0) return;
        if (n == 1) {
            arr[r][c] = k;
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[r][c + i] = k++;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[r + i][c + n - 1] = k++;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[r + n - 1][c + n - 1 - i] = k++;
        }
        for (int i = 0; i < n - 1; i++) {
            arr[r + n - 1 - i][c] = k++;
        }
        generateMatrix(arr, r + 1, c + 1, n - 2, k);
    }
}