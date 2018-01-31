class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length - 1);
    }
    
    private TreeNode BST(int[] nums, int low, int high) {
        if (low > high) return null;
        
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BST(nums, low, mid - 1);
        node.right = BST(nums, mid + 1, high);
        
        return node;
    }
}