import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> flist = new ArrayList<>(numRows);
        for(int rows = 0; rows < numRows; rows++)
        {
            List<Integer> temp = new ArrayList<>(numRows);
            temp.add(1);
            for(int cols = 1; cols<=rows; cols++)
            {
                if(cols==rows) temp.add(1);
                else
                temp.add(flist.get(rows-1).get(cols-1)+flist.get(rows-1).get(cols));
            }
            flist.add(temp);
        }
        return flist;
    }
}