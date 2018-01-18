// 格雷码转换成整数有数学公式
class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(binaryToGray(i));
        }
        
        return result;
    }
    
    private int binaryToGray(int n) {
        return n ^ (n >> 1);
    }
}

// n位格雷码可以递归的用n-1位格雷码生成
// 可参考pdf
class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> result = new ArrayList<>(size);
        
        result.add(0);
        for (int i = 0; i < n; i++) {
            int highestBit = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) | highestBit);
            }
        }
        
        return result;
    }
}