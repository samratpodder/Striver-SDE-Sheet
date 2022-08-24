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
    public boolean findTarget(TreeNode root, int k) {
        return run(root,k,root);
    }
    public boolean run(TreeNode root, int k, TreeNode currentNode) {
    if (currentNode == null) return false;
    if (find(root, currentNode, k-currentNode.val)) return true;
    
    return run( currentNode.left, k,root) || run(currentNode.right,k,root  );
}
    public boolean find(TreeNode root, TreeNode current, int val) {
    if (root == null) return false;
    if (val > root.val) return find(root.right, current, val);
    else if (val < root.val) return find(root.left, current, val);
    else if (val == root.val) return root != current;
    
    return false;
}
}