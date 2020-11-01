class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = indexOf(seats, 0);
        int j = lastIndexOf(seats, seats.length - 1);
        int maxDist = Math.max(i, seats.length - 1 - j);

        while (i < j) {
            int temp = indexOf(seats, i + 1);
            maxDist = Math.max(maxDist, (temp - i) / 2);
            i = temp;
        }

        return maxDist;
    }

    private int indexOf(int[] seats, int start) {
        for (int i = start; i < seats.length; i++) {
            if (seats[i] == 1) return i;
        }
        return -1;
    }

    private int lastIndexOf(int[] seats, int end) {
        for (int i = end; i >= 0; i--) {
            if (seats[i] == 1) return i;
        }
        return -1;
    }
}