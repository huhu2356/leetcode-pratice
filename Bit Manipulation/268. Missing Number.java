public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= (i + 1) ^ nums[i];
        }
        return result;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length;
        while (begin != end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] > mid) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        
        return begin;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int n = nums.length;
        int sumExpected = (n * (n + 1)) / 2;
        
        return sumExpected - sum;
    }
}