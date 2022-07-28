import java.util.ArrayList;

class Solution {
    static boolean isPossible(ArrayList < Integer > A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A.get(i);
            }
        }
        if (cnt < students) return true;
        return false;
    }
    public int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1;
        int lo=Integer.MAX_VALUE;
        int hi=0;
        for(int i=0;i<A.size();i++)
        {
            lo = Math.min(lo,A.get(i));
            hi+=A.get(i);
        }
        while (lo<=hi) {
            int mid = (lo+hi)>>>1;
            if(isPossible(A, mid, B)){
                hi=mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}
