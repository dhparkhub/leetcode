class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int temp = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) continue;
            if (i - 1 >= 0 && flowerbed[i - 1] != 0) continue;
            if (i + 1 < flowerbed.length && flowerbed[i + 1] != 0) continue;
            flowerbed[i] = 1;
            temp++;
        }
        return temp >= n;
    }
}