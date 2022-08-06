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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().index;
            for(int i=0;i<size;i++){
                int currID = q.peek().index-mmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = currID;
                if(i==size-1) last = currID;
                if(node.left!=null){
                    q.offer(new Pair(node.left,currID*2+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,currID*2+2));
                }
            }
            res = Math.max(res, last-first+1);
        }
        return res;
    }
}