class Solution {
    public int longestMountain(int[] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j + 1 < arr.length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (j == i) continue;
            int k = j;
            while (k + 1 < arr.length && arr[k + 1] < arr[k]) {
                k++;
            }
            if (k == j) continue;
            answer = Math.max(answer, k - i + 1);
            i = j;
        }
        return answer;
    }
}