import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (Integer integer : nums) {
            set.add(integer);
        }
        int gmax=0,lmax=1;
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1) && set.contains(nums[i])){
                lmax=0;
                int j = 0;
                while(set.contains(nums[i]+j)) {
                    lmax++;
                    j++;
                }
            }
            gmax = Math.max(lmax, gmax);
        }
        return gmax;
    }
}