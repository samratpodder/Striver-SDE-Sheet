import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        int count =0;
        int xorval =0;
        for(int i=0;i<arr.size();i++)
        {
            xorval ^= arr.get(i);
            if(xorval==x) count++;
            if(visited.containsKey(xorval^x))
            {
                count+=visited.get(xorval^x);
            }
            if(visited.containsKey(xorval))
                visited.put(xorval,visited.get(xorval)+1);
            else{
                visited.put(xorval,1);
            }
        }
        return count;
	}
}