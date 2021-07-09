class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer += parseRoman(s, i);
        }//O(N)
        return answer;
    }//O(N)

    private int parseRoman(String s, int i) {
        char ch = s.charAt(i);
        if (i == s.length() - 1) {
            return parseRoman(ch);
        }
        char compCh = s.charAt(i + 1);
        if (parseRoman(ch) < parseRoman(compCh)) {
            return -parseRoman(ch);
        }//[IV, IX, XL, XC, CD, CD]
        return parseRoman(ch);
    }//O(1)

    private int parseRoman(char ch) {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        return 1000;
    }//O(1)
}