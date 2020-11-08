import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length && q.size() <= arr.length; i++) {
            q.add(arr[i]);
            if (arr[i] == 0) q.add(arr[i]);
        }// O(N)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = q.poll();
        }// O(N)
    }
}