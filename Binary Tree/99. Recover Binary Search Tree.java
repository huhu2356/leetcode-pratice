class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root);
                vals.add(root.val);
                root = root.right;
            }
        }
        Collections.sort(vals);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).val != vals.get(i)) {
                res.get(i).val = vals.get(i);
            }
        }
    }
}