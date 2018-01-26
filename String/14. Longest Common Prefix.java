class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        int right_most = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < right_most; j++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                    right_most = j;
                }
            }
        }
        
        return strs[0].substring(0, right_most);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
       for (int j = 0; j < strs[0].length(); j++) {
           for (int i = 1; i < strs.length; i++) {
               if (j == strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                   return strs[0].substring(0, j);
               }
           }
       } 
        
        return strs[0];
    }
}