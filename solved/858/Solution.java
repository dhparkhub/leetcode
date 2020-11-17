class Solution {
    public int mirrorReflection(int p, int q) {
        int lcm = lcm(p, q);
        int temp1 = lcm / q;
        if (temp1 % 2 == 0) return 2;
        int temp2 = lcm / p;
        if (temp2 % 2 == 1) return 1;
        return 0;
    }

    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    private int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}