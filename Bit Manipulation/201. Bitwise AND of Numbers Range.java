// 找到公共的左边部分
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while ((mask & m) != (mask & n)) {
            mask <<= 1;
        }
        
        return m & mask;
    }
}

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= n - 1;
        }
        
        return n & m;
    }
}
