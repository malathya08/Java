class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int index = 0;

        s = s.trim();

        if (s.length() == 0)
            return 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9')
                break;
            int digit = ch - '0';
            if (result > (2147483647 - digit) / 10) {
                if (sign == 1)
                    return 2147483647;
                else
                    return -2147483648;
            }

            result = result * 10 + digit;
        }
        return result * sign;
    }
}
