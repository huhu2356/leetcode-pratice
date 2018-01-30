class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        boolean reverseFlag = false;
        
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
            if (reverseFlag) Collections.reverse(level);
            reverseFlag = !reverseFlag;
            res.add(level);
            current.addAll(next);
            next.clear();
        }
        
        return res;
    }
}


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        boolean flag = false;
        
        if (root == null) {
            return res;
        } else {
            current.push(root);
        }
        
        while (!current.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!current.isEmpty()) {
                TreeNode cur = current.pop();
                level.add(cur.val);
                if (flag) {
                    if (cur.right != null) next.push(cur.right);
                    if (cur.left != null) next.push(cur.left); 
                } else {
                    if (cur.left != null) next.push(cur.left);
                    if (cur.right != null) next.push(cur.right);
                }
            }
            res.add(level);
            flag = !flag;
            current.addAll(next);
            next.clear();
        }
        
        return res;
    }
}