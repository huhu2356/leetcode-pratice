class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndexInorder = map.get(postorder[postEnd]);
        int leftSubTreeLen = rootIndexInorder - inStart;
        int rightSubTreeLen = inEnd - rootIndexInorder;
        root.left = helper(inorder, inStart, rootIndexInorder - 1, postorder, postStart, postStart + leftSubTreeLen - 1, map);
        root.right = helper(inorder, rootIndexInorder + 1, inEnd, postorder, postStart + leftSubTreeLen, postEnd - 1, map);
        return root;
    }
}