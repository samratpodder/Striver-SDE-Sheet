class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo<hi){
            int mid = (lo+hi)>>1;
            if(mid==0||mid==nums.length-1) return nums[mid];
            if(nums[mid]==nums[mid^1]) lo=mid+1; //Check if its partner is same or not 0-1, 1-2, 2-3
            else hi = mid;
        }
        return nums[lo];
    }
}