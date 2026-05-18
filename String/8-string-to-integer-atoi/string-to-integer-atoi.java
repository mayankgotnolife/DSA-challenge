class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        int sign = 1;
        int result = 0;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        if (s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < n) {
            char c = s.charAt(index);
            
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            if (sign == 1) {
                if (result > 214748364 || (result == 214748364 && digit > 7)) {
                    return 2147483647; 
                }
            } else {
                if (result > 214748364 || (result == 214748364 && digit >= 8)) {
                    return -2147483648; 
                }
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}