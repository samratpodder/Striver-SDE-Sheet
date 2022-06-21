import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        return sort(arr, 0, n-1);
    }
    public static long sort(long[] arr, int lo, int hi){
        if(lo<hi)
        {
            int mid = lo + (hi-lo)/2;
            return sort(arr,lo,mid) + sort(arr, mid+1, hi) + merge(arr, lo, mid, hi);
        }
        return 0;
    }
    public static long merge(long[] arr, int lo, int mid, int hi){
        System.out.println("---");
        int len1 = mid-lo+1;
        int len2 = hi-mid;
        long[] half1 = new long[len1];
        long[] half2 = new long[len2];
        for (int i = 0; i < half1.length; i++) {
            half1[i] = arr[lo+i];
            System.out.print(half1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < half2.length; i++) {
            half2[i] = arr[mid+1+i];
            System.out.print(half2[i]+" ");
        }
        System.out.println();
        System.out.println("---");
        
        int i=0,j=0,k=lo;
        long countInv = 0;
        while(i<len1 && j<len2){
            if(half1[i]<=half2[j]){
                arr[k++]=half1[i++];
            }
                
            else {
                long temp=countInv;
                System.out.println(half1[i]+"--"+half2[j]);
                arr[k++] = half2[j];
                countInv+=(mid+1+j-(lo+i));
                j++;
//                 i++;
                System.out.println("Pairs = "+(countInv-temp));break;
//                 j=len2;
            }
        }
        while(i<len1)
        {
            arr[k++] = half1[i++];
            System.out.println(arr[k-1]+" was left");
        }
        while(j<len2){
            arr[k++] = half2[j++];
        }
        return countInv;
    }
}