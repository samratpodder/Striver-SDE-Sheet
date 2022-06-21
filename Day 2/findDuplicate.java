class Solution {
    public int findDuplicatewithOneRepeatations(int[] nums) {
        long sum = sumOf(nums);
        int n = maxOf(nums);
        return (int)sum-(n*(n+1)/2);
    }
    public static long sumOf(int[] arr){
        long sum=0;
        for(int element: arr)
            sum+=element;
        return sum;
    }
    public static int maxOf(int[] arr){
        int max = -1;
        for(int element : arr)
            max = Math.max(element,max);
        return max;
    }
    //Hare Tortoise Mechanism
    public int findDuplicate(int[] nums) {
        int slow = nums[0],fast = nums[0];
        while(true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = nums[0];
        while(slow!=fast)
        {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}