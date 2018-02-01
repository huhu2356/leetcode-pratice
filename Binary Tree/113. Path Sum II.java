class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root, sum, cur, res);
        
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList(cur));
        }
        helper(root.left, sum - root.val, cur, res);
        helper(root.right, sum - root.val, cur, res);
        cur.remove(cur.size() - 1);
    }
}