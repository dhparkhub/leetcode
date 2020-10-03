class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (evenNumOfDigit(num)) {
                count++;
            }
        }
        return count++;
    }

    private boolean evenNumOfDigit(int num) {
        int temp = 0;
        while (num != 0) {
            temp++;
            num /= 10;
        }
        return temp % 2 == 0;
    }
}