// N = 8
// A[] = {15,-2,2,-8,1,7,10,23}
// Output: 5
// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> firstOccurenceof = new HashMap<>();
        int maxi=1, preSum =0;
        for (int i = 0; i < n; i++) {
            preSum+=arr[i];
            if (preSum==0) {
                maxi = i+1;
            }
            else{
                if(firstOccurenceof.containsKey(preSum))
                {
                    maxi = Math.max(maxi, i-firstOccurenceof.get(preSum));
                }
                else{
                    firstOccurenceof.put(preSum, i);
                }
            }
        }
        return maxi;
    }
}