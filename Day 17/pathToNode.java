/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        func(A,B,list);
        return list;
    }
    public boolean func(TreeNode root, int search, ArrayList<Integer> path){
        if(root == null) return false;
        if(root.val==search){
            path.add(root.val);
            return true;   
        }
        path.add(root.val);
        if(func(root.left,search,path)) return true;
        if(func(root.right,search,path)) return true;
        path.remove(path.size()-1);
        return false;
    }
}
