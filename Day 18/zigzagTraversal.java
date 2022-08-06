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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new LinkedList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        List<Integer> temp = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        while(!(s1.isEmpty() && s2.isEmpty())){
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();
                temp.add(curr.val);
                if(curr.left != null) s2.push(curr.left);
                if(curr.right != null) s2.push(curr.right);
                
            }
            // System.out.println(temp);
            if(temp.size()>0) res.add(new LinkedList<>(temp));
            temp = new LinkedList<>();
            while(!s2.isEmpty()){
                TreeNode curr = s2.pop();
                temp.add(curr.val);
                if(curr.right != null) s1.push(curr.right);
                if(curr.left != null)  s1.push(curr.left);
                
            }
            // System.out.println(temp);
            if(temp.size()>0) res.add(new LinkedList<>(temp));
            temp = new LinkedList<>();
        }    
        return res;
    }
}