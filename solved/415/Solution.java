class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            int x = index1 < 0 ? 0 : num1.charAt(index1) - '0';
            int y = index2 < 0 ? 0 : num2.charAt(index2) - '0';
            int sum = x + y + carry;
            result.append(sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }
        return carry == 1 ? result.append(1).reverse().toString() : result.reverse().toString();
    }
}