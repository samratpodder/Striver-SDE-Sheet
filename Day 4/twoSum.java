import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> pair = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(pair.containsKey(target-nums[i]))
            {
                res[0] = pair.get(target-nums[i]);
                res[1] = i;
                break;
            }
            else pair.put(nums[i], i);
        }
        return res;
    }
}