/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public  static int findCeil(TreeNode<Integer> root, int x) {

        // Write your code here
        int res = -1;
        while(root!=null){
            if(root.data==x) return x;
            else if(root.data<x) root=root.right;
            else{
                res=root.data;
                root=root.left;
            }
        }
        return res;
    }
}
