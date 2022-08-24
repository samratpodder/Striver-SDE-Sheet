class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        dfs(root,null);
        return root;
    }
    private void dfs(Node root, Node connectTo){
        if(root==null) return;
        root.next = connectTo;
        dfs(root.left,root.right);
        dfs(root.right,root.next==null?null:root.next.left);
    }
}