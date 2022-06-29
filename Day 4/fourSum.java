import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length;i++) {
            for (int j = i+1; j < nums.length;j++) {
                int low = j+1,hi = nums.length-1;
                long searching = target-nums[i]-nums[j];
                while (low<hi) {
                    if(searching>(long)nums[low]+nums[hi])
                    {
                        // while(low<nums.length && nums[low]==nums[low+1]) 
                        low++;
                    }
                    else if(searching<(long)nums[low]+nums[hi]){
                        // while(hi>j && nums[hi]==nums[hi-1]) 
                        hi--;
                    }
                    else
                    {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[low]);
                        l.add(nums[hi]);
                        ret.add(l);
                        while(low<hi && nums[low]==l.get(2)) low++;
                        while(low<hi && nums[hi]==l.get(3)) hi--;
                    }
                }
                while(j+1<nums.length && nums[j]==nums[j+1]) j++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        }
        return ret;
    }
}