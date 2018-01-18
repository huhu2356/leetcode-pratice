class Solution {
    public int singleNumber(int[] nums) {
        int W = Integer.SIZE;
        int[] counter = new int[W];
        
        for (int i : nums) {
            for (int j = 0; j < W; j++) {
                if ((i & 1) == 1) {
                    counter[j]++;
                }
                i >>= 1;
            }
        }
        
        int result = 0;
        for (int i = 0; i < W; i++) {
            if (counter[i] % 3 != 0) {
                result += 1 << i;
            }
        }
        
        return result;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i : nums) {
            two |= (one & i);
            one ^= i;
            three = ~(two & one);
            one &= three;
            two &= three;
        }
        
        return one;
    }
}