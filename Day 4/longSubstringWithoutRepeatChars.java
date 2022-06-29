// Input: s = "pwwkew"
// Output: 3
import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res =0,st=0;
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);
        for (int i = 0; i < s.length(); i++) {
            st=Math.max(st,lastSeen[s.charAt(i)]+1);
            lastSeen[s.charAt(i)]=i;
            res = Math.max(res,i-st+1);
        }
        return res;
    }
}