/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = func(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public static TreeNode func(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd, HashMap<Integer, Integer> map){
        if (preSt > preEnd || inSt > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preSt]);
        int inRootPos = map.get(preorder[preSt]);
        int numsOnLeft = inRootPos - inSt;
        root.left = func(preorder, preSt+1,preSt+numsOnLeft+1,inorder,inSt,inRootPos -1, map);
        root.right = func(preorder, preSt+numsOnLeft+1,preEnd,inorder,inRootPos+1,inEnd, map);
        return root;
    }
}