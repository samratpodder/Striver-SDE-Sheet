import java.util.ArrayList;
class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            lo = Math.min(lo,A.get(i).get(0));
            hi = Math.max(hi, A.get(i).get(A.get(i).size()-1));
        }
        while (lo<=hi) {
            int mid = (lo+hi)>>1;
            int count = 0;
            for (int i = 0; i < A.size(); i++) {
                count+=countNumbersSmallerThanEqualtoMid(A.get(i),mid);
            }
            if(count<=(A.size()*A.get(0).size())>>1) lo=mid+1;
            else hi=mid-1;
        }
        return lo;
    }

    private int countNumbersSmallerThanEqualtoMid(ArrayList<Integer> arrayList, int midEle) {
        int n = arrayList.size();
        int lo = 0, hi  = n-1;
        while (lo<=hi) {
            int mid = (lo+hi)>>1;
            if(arrayList.get(mid)<=midEle){
                lo=mid+1;
            }
            else hi = mid-1;
        }
        return lo;
    }
}