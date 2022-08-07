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

// inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// [3,9,20,null,null,15,7]

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = func(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public static TreeNode func(int[] postorder, int postSt, int postEnd, int[] inorder, int inSt, int inEnd, HashMap<Integer, Integer> map){
        if (postSt > postEnd || inSt > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int indexRoot = map.get(root.val);
        int nodesOnLeft = indexRoot - inSt;
        root.left = func(postorder,postSt,postSt+nodesOnLeft-1, inorder, inSt,indexRoot-1,map);
        root.right = func(postorder,postSt+nodesOnLeft,postEnd-1, inorder, indexRoot+1,inEnd,map);
        return root;
    }
}