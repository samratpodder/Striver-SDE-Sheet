class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return func(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean func(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val>=max) return false;
        if(root.val<=min) return false;

        return func(root.right,root.val,max) && func(root.left,min,root.val);

    }
}