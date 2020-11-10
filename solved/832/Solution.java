class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] arr : A) {
            flip(arr);
        }
        return A;
    }

    private void flip(int[] arr) {
        int half = arr.length / 2;
        for (int i = 0; i < half; i++) {
            int j = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[j] == 0 ? 1 : 0;
            arr[j] = temp == 0 ? 1 : 0;
        }
        if (arr.length % 2 == 1) {
            arr[half] = arr[half] == 0 ? 1 : 0;
        }
    }
}