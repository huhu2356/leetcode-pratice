// 从右向左把一位位取出来，添加到返回结果数中
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int digit = n & 1;
            res = (res << 1) + digit;
            n = n >> 1;
        }
        
        return res;
    }
}

// 双指针，从两边开始把不相等的两位交换数值，也就是对自身取反，也就是与1异或
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left = 0;
        int right = 31;
        while (left < right) {
            int x = (n >> left) & 1;
            int y = (n >> right) & 1;
            if (x != y) {
                n ^= (1 << left) | (1 << right);
            }
            left++;
            right--;
        }
        
        return n;
    }
}