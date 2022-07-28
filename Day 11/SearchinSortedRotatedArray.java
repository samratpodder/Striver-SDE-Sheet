class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        if(nums.length<=1) return nums[0]==target?0:-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]){
                
             if(target<nums[mid]&&target>=nums[l]){
                    h=mid-1;
                }
                else l=mid+1;
            }
            if(nums[mid]<=nums[h]){
                if(target>nums[mid]&&target<=nums[h]) l=mid+1;
                else h=mid-1;
            }
        }
        return -1;
    }
}