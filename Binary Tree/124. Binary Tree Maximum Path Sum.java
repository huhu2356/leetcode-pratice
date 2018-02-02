class Solution {
    public int maxPathSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(Integer.MIN_VALUE);
        helper(root, res);
        return res.get(0);
    }
    
    private int helper(TreeNode root, List<Integer> res) {
        if (root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int sum = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if (sum > res.get(0)) {
            res.set(0, sum);
        }
        return root.val + Math.max(0, Math.max(left, right));
    }
}