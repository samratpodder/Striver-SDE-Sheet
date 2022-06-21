class Solution {
    public int[] findErrorNums(int[] nums) {
        // int dup = nums[0];
        // int trueSum = nums[0];
        // for(int i =1;i<nums.length;i++)
        // {
        //     trueSum+=Math.abs(nums[i]);
        //     if(nums[Math.abs(nums[i])-1]<0) dup = nums[i];
        //     else nums[Math.abs(nums[i])-1]*=-1;
        // }
        // int correctSum = (nums.length*(nums.length+1))/2;
        // return new int[]{dup,correctSum-(trueSum-dup)};
        int dup=0;
        HashSet<Integer> myset = new HashSet<>();
        for(int element: nums)
        {
            if(myset.contains(element))
                dup=element;
            else myset.add(element);
        }
        for(int i =1;i<=nums.length;i++)
        {
            if(!myset.contains(i)) return new int[]{dup,i};
        }
        return new int[]{dup,nums.length};
    }
}