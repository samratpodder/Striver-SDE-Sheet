//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              vis[i][j] = 0;
            }
        }
        if (m[0][0] == 1) func(res,"",m,0,0,n,vis);
        return res;
    }
    public static void func(ArrayList<String> res,String path,int[][] m, int row, int col, int n, int[][] vis){
        if(row==n-1 && col==n-1){
            res.add(path);
            return;
        }
        if(row+ 1 < n && vis[row + 1][col] == 0 && m[row+1][col]!=0){
            vis[row][col]=1;
            func(res, path+'D', m, row+1, col, n,vis);
            vis[row][col]=0;
        }
        if(col- 1 >= 0 && vis[row][col-1]==0 && m[row][col-1]!=0){
            vis[row][col]=1;
            func(res, path+'L', m, row, col-1, n,vis);
            vis[row][col]=0;
        }
        if(col + 1 < n && vis[row][col+1]==0 && m[row][col+1]!=0){
            vis[row][col]=1;
            func(res, path+'R', m, row, col+1, n,vis);
            vis[row][col]=0;
        }
        if(row - 1 >= 0&& vis[row-1][col]==0 && m[row-1][col]!=0)
        {
            vis[row][col]=1;
            func(res,path+'U',m,row-1,col,n,vis);
            vis[row][col]=0;
        }
    }
}