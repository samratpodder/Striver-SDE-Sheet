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
    private static TreeNode prev;
    public void flatten(TreeNode root) {
        root = func(root,null);
    }
    private static TreeNode func(TreeNode root, TreeNode prev){
        if(root==null) return prev;
        prev = func(root.right,prev);
        prev = func(root.left, prev);
        root.right = prev;
        root.left = null;
        prev=root;
        return prev;
    }
}