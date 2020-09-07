class Solution {
    private final int[] mr = {0, 1, 0, -1};
    private final int[] mc = {1, 0, -1, 0};
    private int maxR, maxC;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int count = 0;
        maxR = grid.length;
        maxC = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';// visited
        for (int i = 0; i < 4; i++) {
            int nr = r + mr[i];
            int nc = c + mc[i];
            if (isValid(nr, nc) && grid[nr][nc] == '1') {
                dfs(grid, nr, nc);
            }
        }
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < maxR && c >= 0 && c < maxC;
    }
}