import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] answer = new int[A.length];

        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                answer[i] = A[i] * A[i];
            }
            return answer;
        }

        if (A[A.length - 1] < 0) {
            for (int i = 0; i < A.length; i++) {
                answer[i] = A[A.length - 1 - i] * A[A.length - 1 - i];
            }
            return answer;
        }

        int zeroIndex = Arrays.binarySearch(A, 0);
        int index = zeroIndex > 0 ? 1 : 0;
        int left = zeroIndex > 0 ? zeroIndex - 1 : -(zeroIndex) - 2;
        int right = zeroIndex > 0 ? zeroIndex + 1 : -(zeroIndex) - 1;
        while (left >= 0 && right < A.length) {
            if (Math.abs(A[left]) < A[right]) {
                answer[index++] = A[left] * A[left];
                left--;
            } else {
                answer[index++] = A[right] * A[right];
                right++;
            }
        }

        while (left >= 0) {
            answer[index++] = A[left] * A[left];
            left--;
        }

        while (right < A.length) {
            answer[index++] = A[right] * A[right];
            right++;
        }

        return answer;
    }
}