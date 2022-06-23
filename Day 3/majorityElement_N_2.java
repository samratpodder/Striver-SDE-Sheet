class Solution {
    public int majorityElement(int[] nums) {
        int trust =1;
        int candidate = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(candidate == nums[i]) trust++;
            else{
                trust--;
                if(trust==0)
                {
                    candidate = nums[i];
                    trust=1;
                }
            }
        }
        return candidate;
    }
}