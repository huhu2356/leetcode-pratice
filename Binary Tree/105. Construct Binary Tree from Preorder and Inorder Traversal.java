// 在inorder中查找指定value的index可用hashmap优化
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }
        int leftSubTreeLen = rootIndex - inStart;
        int rightSubTreeLen = inEnd - rootIndex;
        node.left = helper(preorder, preStart + 1, preStart + leftSubTreeLen, inorder, inStart, rootIndex - 1);
        node.right = helper(preorder, preStart + leftSubTreeLen + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return node;
    }
}