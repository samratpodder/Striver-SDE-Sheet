class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0,right = matrix[0].length-1,top = 0, bottom = matrix.length-1;
        while(top<=bottom&&left<=right)
        {
            int midH = left+(right-left)/2, midV = top + (bottom-top)/2;
            if(target==matrix[midV][midH]) return true;
            if(target<matrix[midV][midH])
            {
                if(target<matrix[midV][0])
                    bottom = midV-1;
                else right = midH-1;
            }
            else{
                if(target>matrix[midV][matrix[0].length-1])
                    top = midV+1;
                else left= midH+1;
            }
        }
        return false;
    }
}