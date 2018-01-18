class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        int p = 0;
        while (p < 32) {
            if ((res & 1) > 0) {
                break;
            }
            res >>= 1;
            p++;
        }
        
        int res1 = 0;
        int res2 = 0;
        for (int i : nums) {
            if (((i >> p) & 1) > 0) {
                res1 ^= i;
            } else {
                res2 ^= i;
            }
        }
        
        return new int[] {res1, res2};
    }
}