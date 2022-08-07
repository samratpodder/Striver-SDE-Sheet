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
    public int maxPathSum(TreeNode root) {
        int[] maxFound = new int[1];
        maxFound[0] = Integer.MIN_VALUE;
        maxSum(root,maxFound);
        return maxFound[0];
    }
    public int maxSum(TreeNode root, int[] maxFound){
        if(root==null) return 0;
        int left = Math.max(0,maxSum(root.left,maxFound));
        int right = Math.max(0,maxSum(root.right,maxFound));
        maxFound[0] = Math.max(maxFound[0], root.val+left+right);
        return root.val+Math.max(left,right);
    }
}