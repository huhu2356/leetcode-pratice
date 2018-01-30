class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        
        if (root == null) {
            return res;
        } else {
            current.offer(root);
        }
        
        while (!current.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!current.isEmpty()) {
                TreeNode cur = current.poll();
                level.add(cur.val);
                if (cur.left != null) next.offer(cur.left);
                if (cur.right != null) next.offer(cur.right);
            }
            res.add(level);
            current.addAll(next);
            next.clear();
        }
        
        return res;
    }
}