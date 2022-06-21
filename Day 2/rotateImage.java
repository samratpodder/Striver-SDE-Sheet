class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i =0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                swap(matrix,i,j,j,i);
            }
        }
        int i =0;
        while(i<n)
        {
            for(int j =0;j<n/2;j++)
                swap(matrix,i,j,i,n-j-1);
            i++;
        }
        // for(i =0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
    public static void swap(int[][] matrix, int i, int j, int x, int y)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}