public class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }
    public static int sort(int[] arr, int lo, int hi){
        if(lo<hi)
        {
            int mid = lo + (hi-lo)/2;
            return sort(arr,lo,mid) + sort(arr, mid+1, hi) + merge(arr, lo, mid, hi);
        }
        return 0;
    }
    public static int merge(int[] arr, int lo, int mid, int hi){
        int len1 = mid-lo+1;
        int len2 = hi-mid;
        int[] half1 = new int[len1];
        int[] half2 = new int[len2];
        for (int i = 0; i < half1.length; i++) {
            half1[i] = arr[lo+i];
        }
        for (int i = 0; i < half2.length; i++) {
            half2[i] = arr[mid+1+i];
        }   

        int i=0,j=0,k=lo;
        int countPair = 0;
        while(i<len1 && j<len2)
        {
            if(half1[i]>(long)half2[j]*2)
            {
                countPair+=(len1-i);
                j++;
            }
            else i++;
        }
        i=0;j=0;
        while(i<len1 && j<len2){
            if(half1[i]<=half2[j]){
                arr[k++]=half1[i++];
            }
                
            else {
                arr[k++] = half2[j++];
            }
        }
        while(i<len1)
        {
            arr[k++] = half1[i++];
        }
        while(j<len2){
            arr[k++] = half2[j++];
        }
        return countPair;
    }
}
