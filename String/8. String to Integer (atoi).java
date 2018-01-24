// 整数处理需要考虑正负号问题，整数越界问题

class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        
        str = str.trim();
        if (str.length() == 0) return 0;
        int num = 0;
        int sign = 1;
        int i = 0;
        
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            int digit = str.charAt(i) - '0';
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 &&
                            digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
            }
            num = num * 10 + digit;
            i++;
        }
        
        return sign * num;
    }
}