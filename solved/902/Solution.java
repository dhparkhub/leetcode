class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int temp = n;
        int i = 1;
        int sum = 0;
        while (temp / 10 != 0) {
            sum += Math.pow(digits.length, i++);
            temp /= 10;
        }

        return sum + f(digits, String.valueOf(n));
    }

    private int f(String[] digits, String n) {
        int ret = 0;

        if (n.length() == 1) {
            for (String digit : digits) {
                if (digit.charAt(0) <= n.charAt(0)) {
                    ret++;
                }
            }
            return ret;
        }

        for (String digit : digits) {
            if (digit.charAt(0) < n.charAt(0)) {
                ret += Math.pow(digits.length, n.length() - 1);
                continue;
            }
            if (digit.charAt(0) == n.charAt(0)) {
                ret += f(digits, n.substring(1));
            }
        }
        return ret;
    }
}