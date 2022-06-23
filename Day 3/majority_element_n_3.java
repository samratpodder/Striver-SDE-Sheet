class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> retList = new ArrayList<>();
        if(nums.length==1){
            retList.add(nums[0]);
            return retList;
        } 
        int num1 = nums[0], num2 = nums[0],c1 = 1,c2 = 0;
        for(int i = 1; i < nums.length ;i++)
        {
            if(nums[i]==num1) c1++;
            else if(nums[i]==num2) c2++;
            else if(c1==0){
                num1 = nums[i];
                c1=1;
            }
            else if(c2==0)
            {
                num2 = nums[i];
                c2=1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;c2=0;
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i] == num1)c1++;
            else if(nums[i] == num2) c2++;
        }
        if(c1>nums.length/3) retList.add(num1);
        if(c2>nums.length/3) retList.add(num2);
        return retList;
    }
}