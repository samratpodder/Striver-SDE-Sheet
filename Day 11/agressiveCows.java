import java.util.*;
import java.lang.*;

class agressiveCows
{
    public static boolean isPossible(long[] barnPos, int cows, long diff){
        long prevPos = barnPos[0];cows--;
        for (int i = 1; i < barnPos.length; i++) {
            if(barnPos[i]-prevPos>=diff){
                cows--;
                prevPos=barnPos[i];
            }
            if(cows==0) return true;
        }
        return false;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-->0) {
            int barns = sc.nextInt();
            int cows=sc.nextInt();
            long[] barnPos = new long[barns];
            for (int i = 0; i < barnPos.length; i++) {
                barnPos[i] = sc.nextLong();
            }
            Arrays.sort(barnPos);
            long lo = barnPos[0];
            long hi = barnPos[barns-1] - lo;
            long res=-1;
            while (lo<=hi) {
                long mid = lo+(hi-lo)/2;
                if(isPossible(barnPos,cows,mid)){
                    lo=mid+1;
                    res=mid;
                }
                else{
                    hi=mid-1;
                }
            }
            System.out.println(res);
        }
	}
}