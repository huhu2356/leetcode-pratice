class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.isEmpty()) return 0;
        
        if (needle.length() > haystack.length()) return -1;
        
        int N = haystack.length() - needle.length();      
        for (int i = 0; i <= N; i++) {
            int j = i;
            int k = 0;
            while (j < haystack.length() && k < needle.length()) {
                if (haystack.charAt(j) != needle.charAt(k)) break;
                j++;
                k++;
            }
            if (k == needle.length()) return i;
        }
        
        return -1;
    }
}