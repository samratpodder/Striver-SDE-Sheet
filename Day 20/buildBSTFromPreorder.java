class Solution {
    static int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==1) return new TreeNode(preorder[preorder.length-1]);
        index=0;
        return func(preorder,Integer.MAX_VALUE);
    }
    private TreeNode func(int[] preorder,int prevRootValue){
        if(index>=preorder.length) return null;
        if(preorder[index]>prevRootValue) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = func(preorder,root.val);
        root.right = func(preorder,prevRootValue);
        return root;
    }
}