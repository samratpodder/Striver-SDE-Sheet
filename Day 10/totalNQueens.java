class Solution {
    public int totalNQueens(int n) {
        boolean[] lowerDiagonal = new boolean[2*n-1],upperDiagonal = new boolean[2*n-1], rowTaken = new boolean[n];
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] arr = new char[n];
            Arrays.fill(arr,'.');
            board.add(new String(arr));
        }
        return func(lowerDiagonal,upperDiagonal,rowTaken,board,n,0);
    }
    public int func(boolean[] lD, boolean[] uD, boolean[] rT, List<String> board, int n, int col){
        if(col==n) return 1;
        int count =0;
        for(int row=0;row<n;row++){
            if(rT[row]||uD[(n-1)+(col-row)]||lD[row+col])continue;
            char[] arr = board.get(row).toCharArray();
            arr[col] = 'Q';
            board.set(row,new String(arr));
            rT[row] = true;
            lD[row+col] = true;
            uD[(n-1)+(col-row)] = true;
            
            count+= func(lD,uD,rT,board,n,col+1);
            
            rT[row] = false;
            lD[row+col] = false;
            uD[(n-1)+(col-row)] = false;
            board.remove(row);
            arr[col] = '.';
            board.add(row, new String(arr));
        }
        return count;
    }
}