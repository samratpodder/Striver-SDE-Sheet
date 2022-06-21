import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] entry = new int[n], exit = new int[n];
        for(int i = 0;i<n;i++)
        {
            entry[i] = intervals[i][0];
            exit[i] = intervals[i][1];
        }
        Arrays.sort(entry);
        Arrays.sort(exit);
        int counter = 0, enpoint = 0, expoint = 0;
        List<int[]> retVal = new ArrayList<>(n);
        int[] tempList = new int[2];
        while(enpoint < n && expoint <n){
            if(counter==0)
            {
                tempList[0] = entry[enpoint];
            }
            if(entry[enpoint]<=exit[expoint])
            {
                counter++;enpoint++;
            }
            else if (entry[enpoint]>exit[expoint]) {
                counter = Math.max(0, counter-1);
                expoint++;
            }
            if (counter==0) {
                tempList[1] = exit[expoint-1];
                retVal.add(tempList);
                tempList = new int[2];
            }
        }
        if(expoint<n){
            tempList[1] = exit[enpoint-1];
            retVal.add(tempList);
        }
        return retVal.toArray(new int[retVal.size()][]);
    }
}