class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol0 = false;
        int rows = matrix.length, cols = matrix[0].length;
        for(int i =0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if(j==0&&matrix[i][j]==0)
                    isCol0=true;
                else if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
                
            }
        }
        for(int i=rows-1;i>=1;i--)
        {
            for(int j=cols-1;j>=1;j--)
            {
                if(matrix[i][0]==0||matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0)
        {
            for(int i = 0;i<cols;i++)
            {
                matrix[0][i]=0;
            }
        }
        if(isCol0)
        {
            for(int i=0;i<rows;i++)
            {
                matrix[i][0]=0;
            }
        }
    }
}