class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            nums[i] = convertToInt(words[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        
        return result;
    }
    
    private int convertToInt(String s) {
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            x |= 1 << (s.charAt(i) - 'a');
        }
        
        return x;
    }
}