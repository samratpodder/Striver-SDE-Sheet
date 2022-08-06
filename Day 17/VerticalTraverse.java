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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null) return new LinkedList<>();
        TreeMap<Integer,List<Integer>> mylist = new TreeMap<>();
        func(root,0,mylist);
        List<List<Integer>> retVal = new LinkedList<>();
        for(Map.Entry<Integer,List<Integer>> entry:mylist.entrySet()){
            List<Integer> l = entry.getValue();
            Collections.sort(l);
            retVal.add(l);
        } 
        return retVal;
    }
    public void func(TreeNode root, int hd, TreeMap<Integer,List<Integer>> mylist){
        if(root==null) return;
        List<Integer> nodesOnHD = mylist.computeIfAbsent(hd,k -> new LinkedList<>());
        nodesOnHD.add(root.val);
        mylist.put(hd,nodesOnHD);
        func(root.left,hd-1,mylist);
        func(root.right,hd+1,mylist);
    }
}