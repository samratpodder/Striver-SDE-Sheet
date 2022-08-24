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

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int res =Integer.MAX_VALUE;
        while(root!=null){
            if(root.data==X) return X;
            else if(root.data>X) root=root.left;
            else{
                res=root.data;
                root=root.right;
            }
        }
        return res;
    }
    
}