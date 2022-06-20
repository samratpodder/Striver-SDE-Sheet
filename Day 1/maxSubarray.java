import java.util.*;
import java.io.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int retVal = nums[0],lmax=0;
        for(int i = 0; i<nums.length;i++)
        {
            lmax = Math.max(nums[i],lmax+nums[i]);
            retVal = Math.max(lmax,retVal);
        }
        return retVal;
    }
}