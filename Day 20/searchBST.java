class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        if(val<root.val) return searchBST(root.left,val);
        if(val>root.val) return searchBST(root.right,val);
        return root;
    }
}