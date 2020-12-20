class Solution {
    public int cherryPickup(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        return dp(grid, new Integer[maxRow][maxCol][maxRow][maxCol], 0, 0, 0, maxCol - 1);
    }

    private int dp(int[][] grid, Integer[][][][] cache, int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) return -1;
        if (r1 == grid.length - 1) return grid[r1][c1] + grid[r2][c2];
        if (cache[r1][c1][r2][c2] != null) return cache[r1][c1][r2][c2];
        int temp = 0;
        for (int i = -1; i <= 1; i++) {
            int nr1 = r1 + 1;
            int nc1 = c1 + i;
            if (!valid(grid, nr1, nc1)) continue;
            for (int j = -1; j <= 1; j++) {
                int nr2 = r2 + 1;
                int nc2 = c2 + j;
                if (!valid(grid, nr2, nc2)) continue;
                temp = Math.max(temp, dp(grid, cache, nr1, nc1, nr2, nc2));
            }
        }
        return cache[r1][c1][r2][c2] = grid[r1][c1] + grid[r2][c2] + temp;
    }

    private boolean valid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}