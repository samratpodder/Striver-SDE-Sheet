class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] lowerDiagonal = new boolean[2*n-1], upperDiagonal = new boolean[2*n-1], rowTaken = new boolean[n];
        List<List<String>> ans = new LinkedList<>();
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] arr = new char[n];
            Arrays.fill(arr,'.');
            board.add(new String(arr));
        }
        func(lowerDiagonal,upperDiagonal,rowTaken,board,ans,n,0);
        return ans;
    }
    public void func(boolean[] lD, boolean[] uD, boolean[] rT, List<String> board, List<List<String>> res, int n, int col){
        if(col==n){
            res.add(new ArrayList<>(board));
        }
        for(int row=0;row<n;row++){
            if(rT[row]||uD[(n-1)+(col-row)]||lD[row+col])continue;
            char[] arr = board.get(row).toCharArray();
            arr[col] = 'Q';
            board.set(row,new String(arr));
            rT[row] = true;
            lD[row+col] = true;
            uD[(n-1)+(col-row)] = true;
            
            func(lD,uD,rT,board,res,n,col+1);
            
            rT[row] = false;
            lD[row+col] = false;
            uD[(n-1)+(col-row)] = false;
            board.remove(row);
            arr[col] = '.';
            board.add(row, new String(arr));
        }
    }
}