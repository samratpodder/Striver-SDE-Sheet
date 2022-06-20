class Solution {
    public void sortColors(int[] nums) {
        int lo=0,hi=nums.length-1,mid=0;
        while(mid<nums.length && mid<=hi)
        {
            if(nums[mid]==0)
            {
                swap(nums,mid,lo);
                lo++;
                mid++;
            }
            else if(nums[mid]==2)
            {
                swap(nums,mid,hi);
                hi--;
            }
            else mid++;
        }
    }
    public void swap(int[] nums,int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}