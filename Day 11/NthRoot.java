// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static double multiply(double number, int n) {
        double ans = 1;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans; 
    }
    public int NthRoot(int n, int m)
    {
        // code here
        double low = 1;
        double high = m;
        //  eps = 1e-6; 
        while(low<=high) {
            double mid = (low + high) / 2.0; 
            double val = multiply(mid, n);
            if(val==m) return (int)mid;
            if(val < m) {
                low = mid; 
            }
            else {
                high = mid; 
            }
        }
        return -1;
    }
}