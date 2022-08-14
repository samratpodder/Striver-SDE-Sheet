import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek()<nums2[i]) {
                s.pop();
            }
            map.put(nums2[i],s.isEmpty()?-1:s.peek());
            s.push(nums2[i]);
        }
        int[] retval = new int[nums1.length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = map.getOrDefault(nums1[i], -1);
        }
        return retval;
    }
}