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
    static int kk;
    public int kthSmallest(TreeNode root, int k) {
        kk=k;
        return func(root);
    }
    public int func(TreeNode root) {
        if(root==null) return -1;
        int leftVal = func(root.left);
        if(leftVal!=-1) return leftVal;
        kk--;
        if(kk==0) return root.val;
        int rightVal = func(root.right);
        if(rightVal!=-1) return rightVal;
        return -1;
    }
}