class Solution {
    public int minCostToMoveChips(int[] position) {
        int[] chips = new int[2];
        for (int e : position) {
            chips[(e % 2 == 0 ? 1 : 0)]++;
        }
        return Math.min(chips[0], chips[1]);
    }
}