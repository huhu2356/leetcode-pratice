class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) == 2) {
                res.add(temp);
            }
        }
        
        return res;
    }
}

class Solution {
    private static final int LEN = 10;
    
    public List<String> findRepeatedDnaSequences(String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() < LEN) return result;
        
        final Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('A', 0);
        charMap.put('C', 1);
        charMap.put('G', 2);
        charMap.put('T', 3);
        
        final Map<Integer, Character> intMap = new HashMap<>();
        intMap.put(0, 'A');
        intMap.put(1, 'C');
        intMap.put(2, 'G');
        intMap.put(3, 'T');
        
        final Map<Integer, Integer> counter = new HashMap<>();
        
        for (int i = 0; i < s.length() - LEN + 1; i++) {
            final String key = s.substring(i, i + LEN);
            final int hashValue = strToInt(key, charMap);
            counter.put(hashValue, counter.getOrDefault(hashValue, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(intToStr(entry.getKey(), intMap));
            }
        }
        
        return result;
    }
    
    private int strToInt(String key, Map<Character, Integer> charMap) {
        int x = 0;
        for (int i = 0; i < key.length(); i++) {
            x = (x << 2) + charMap.get(key.charAt(i));
        }
        return x;
    }
    
    private String intToStr(int x, Map<Integer, Character> intMap) {
        StringBuilder str = new StringBuilder();
        while (x > 0) {
            str.append(intMap.get(x & 3));
            x >>= 2;
        }
        
        while (str.length() < LEN) {
            str.append(intMap.get(0));
        }
        
        return str.reverse().toString();
    }
}